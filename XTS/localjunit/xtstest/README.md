XTS Service Tests
-----------------

---
**NOTE**

This module does not contain tests. It's not expected to be run
for test cases.

This module provides a classes which are used by other test modules.

---

This directory contains code which supports testing of the XTS war
deployment. The build process produces a web archive which can be
deployed into a WildFly. The deployed code is highly configurable
allowing it to support a variety of different tests.

A system property can set to configure automatic execution of a
specific WSAT or WSBA client/service test once the AS has booted the
XTS service. Several test programs are included which implement a
variety of common test scenarios. For example, in one scenario the
client invokes a single WSBA service which registers multiple
participants each of which will prepare and commit without error.

System property settings specific to each of the test programs can be
employed to enable the client, service and coordinator instances
employed by the test to be located in one, two or more AS
instances. Thus each test program can be used to test a variety of
distributed configurations. In the example cited above the client and
service might be located in one AS while the coordinator might be
located in another AS. System properties would be used to specify the
URL of the client and the URL of the remote coordinator service.

Finally, the test code is expected to be used in conjunction with the
Byteman test automation tool in order to i) trace subsequent execution
of the test and ii) force the available standard WSAT or WSBA
execution scenarios to follow error paths or suffer delays or
crashes. So, continuing the example above a Byteman script might be used
to crash the coordinator AS at commit. Another script might be used to
trace execution of the coordinator host at reboot, detecting whether
or not the recovery code successfully completes the transaction. A
more complicated script might be used to foil initial attempts at
recovery, ensuring that the recovery system retries the commit the
next time it is woken up.

Note that the test suite currently only provides client and service
classes to exercise the WSAT and WSBA 1.0 APIs. This will be remedied
in the near future.

XTS Service Test Service and Test Client
----------------------------------------

The code includes a generic, scriptable web service and client for use
in all WSBAT and WSAT tests. The web service implements a single
remote operation which accepts a list of strings, representing a set
of commands and associated data values. The operation returns a list
of strings representing a set of results and associated data
values. The commands understood by the service can be used to request
the service to enlist WSAT or WSBA participants and to script how
those participants respond to incoming coordination messages such as
`prepare`, `abort`, `complete`, `close` etc. Commands are also available to
allow the client to drive dispatch of participant-led requests in the
WSBA protocol such as `completed`, `cannotComplete` etc.

3 instances of the web service are started up by the AS during
bootstrap. They are located at URLS

```
http://<host>:<port>/xtstest/xtsservice<n>
```

where

* `host` is the value supplied to the AS using the -b option (defaults to
`localhost`)
* `port` is the value configured as the web service http port (defaults to
`8080`)

n is either 1, 2 or 3.

Relevant classes:

```
org.jboss.jbossts.xts.servicetests.client.XTSServiceTestClient
org.jboss.jbossts.xts.servicetests.service.XTSServiceTestPortTypeImpl
```

XTS Service Test Runner
-----------------------

The code includes a deployment mechanism which automates running
individual Service Tests as part of JBoss bootstrap. Class
XTSServiceTestRunnerBean tests the value of System property

```
org.jboss.jbossts.xts.servicetests.XTSServiceTestName
```

during AS boot. If the value of this property names a class which
implements interface XTSServiceTest then an instance of the class is
created and run() in a new thread. The implementing class is expected
to exercise the WSAT or WSBA code by creating an instance of
`XTSServiceTestClient` and invoking its serve() method inside a WSAT or
WSBA transaction the calling `commit/rollback` or `complete/close/cancel`
as appropriate.

Relevant classes:

* `org.jboss.jbossts.xts.servicetests.bean.XTSServiceTestRunnerBean`
* `org.jboss.jbossts.xts.servicetests.client.XTSServiceTestClient`
* `org.jboss.jbossts.xts.servicetests.test.XTSServiceTest`

XTS Service Tests
-----------------

Specific test scenarios are provided by classes which implement
interface `XTSServiceTest`. These are located in package

```
org.jboss.jbossts.xts.servicetests.test
```

Byteman Scripts
-------------

Byteman Scripts which can be used in conjunction with the XTS Service
Tests are located in directory

```
  dd/scripts
```

Individual scripts may work with more than one XTS Service Test and
may work with more than one AS configuration. For example, script

```
  dd/scripts/HeuristicRecoveryAfterDelayedCommit.txt
```

provides a set of rules which modify and trace the operation of the
WSAT coordinator service. The rules cause the coordinator AS to crash
between prepare and commit. At reboot of this AS the rules cause the
coordinator to drop committed messages during the first replay
attempt. Finally, they allow committed messages to be received once a
second replay is attempted.

These rules can be used with the three standard scenarios which employ
a succsessful WSAT prepare and commit i.e. with test classes

```
org.jboss.jbossts.xts.servicetests.test.at.SingleParticipantPrepareAndCommitTest
org.jboss.jbossts.xts.servicetests.test.at.MultiParticipantPrepareAndCommitTest
org.jboss.jbossts.xts.servicetests.test.at.MultiServicePrepareAndCommitTest
```

(n.b. at present a bug in the one phase commit code means that the
first test will fail -- but that's ok :-)

This script will also work correctly irrespective of whether the
coordinator is colocated with the client and services in one AS or
located in a separate AS (in the latter case the client and services
may also be in a single AS or distributed across separate AS
instances).

See the comments in each of the scripts for details of how it can be
used.

Build, Deploy and Use
---------------------

The xtstest war can be built

```
mvn clean install
```

in this directory. The rest of the XTS code needs to have been built
first (run ant in the root dir of the XTS tree).

You need to deploy the war archive on your own if you wish.
The tests in the XTS module uses the war archive to test specific
crash scenarios. See
`XTS/localjunit/crash-recovery-tests` and class `com.arjuna.qa.junit.BaseCrashTest`.

A specific test scenario can be executed by setting System property

```
org.jboss.jbossts.xts.servicetests.XTSServiceTestName
```

to name a class implementing interface `XTSServiceTest` and then booting
the AS. The easiest way to achieve this is to set

```
export JAVAOPTS="-Dorg.jboss.jbossts.xts.servicetests.XTSServiceTestName=org.jboss.jbossts.xts.servicetests.test.<xxx>"
```

Note that when performing a distributed test it is only necessary to
set this property in the host AS which is executing the client
code.

Note also that where the client is colocated with the coordinator or
participant when testing coordinator or participant crash recovery it
is usually necessary to *unset* this property when rebooting the
crashed AS. (Re-)running the client while the recovery code is doing
its stuff is usually inappropriate, especially if Byteman is still
configured to cause a crash when the client tries to commit.

The Byteman agent needs to be deployed as a JVM agent supplied with a
handle on the relevant script file.  This is done by supplying the
relevant command line option to the JVM when starting the AS.

```
export JAVA_OPTS="$JAVA_OPTS -javaagent:${BYTEMAN_HOME}/lib/byteman.jar=script:${JBOSSTS_ROOT}/XTS/trunk/sar/tests/dd/scripts/<script>"
```

`${BYTEMAN_HOME}` should identify the directory into which you have installed
a Byteman release. You can obtain Byteman from the Byteman project page
at http://byteman.jboss.org. Fetch the latest zip  release and unzip it in `${BYTEMAN_HOME}`

`${JBOSSTS_ROOT}` should dentify the root directory of your Narayana source tree

Other command line properties configuring the operation of Byteman which
may be of use are:

```
 -Dorg.jboss.byteman.dump.generated.classes=yes
 -Dorg.jboss.byteman.dump.generated.classes.directory=<dir>
 -Dorg.jboss.byteman.verbose=<any_value_will_do>
```

See the Byteman manual for more details.
