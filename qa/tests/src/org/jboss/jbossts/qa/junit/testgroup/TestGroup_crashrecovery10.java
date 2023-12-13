/*
   Copyright The Narayana Authors
   SPDX-License-Identifier: Apache-2.0
 */

package org.jboss.jbossts.qa.junit.testgroup;

import org.jboss.jbossts.qa.junit.*;
import org.junit.*;

// Automatically generated by XML2JUnit
public class TestGroup_crashrecovery10 extends TestGroupBase
{
	public String getTestGroupName()
	{
		return "crashrecovery10";
	}

	protected Task server0 = null;

	@Before public void setUp()
	{
		super.setUp();
		server0 = createTask("server0", com.arjuna.ats.arjuna.recovery.RecoveryManager.class, Task.TaskType.EXPECT_READY, 480);
		server0.start("-test");
	}

	@After public void tearDown()
	{
		try {
			server0.terminate();
		Task task0 = createTask("task0", org.jboss.jbossts.qa.Utils.RemoveObjectUidStore.class, Task.TaskType.EXPECT_PASS_FAIL, 480);
		task0.perform();
		Task task1 = createTask("task1", org.jboss.jbossts.qa.Utils.RemoveServerIORStore.class, Task.TaskType.EXPECT_PASS_FAIL, 480);
		task1.perform("$(1)", "$(2)");
		} finally {
			super.tearDown();
		}
	}

	@Test public void CrashRecovery10_Test01()
	{
		setTestName("Test01");
		Task server1 = createTask("server1", org.jboss.jbossts.qa.CrashRecovery10Servers.AITServer01.class, Task.TaskType.EXPECT_READY, 480, "server");
		server1.start("Object1", "$(1)");
		Task client0 = createTask("client0", org.jboss.jbossts.qa.CrashRecovery10Clients.Client01b.class, Task.TaskType.EXPECT_PASS_FAIL, 480, "client");
		client0.start("$(1)");
		client0.waitFor();
        server1.terminate();
		Task server2 = createTask("server2", org.jboss.jbossts.qa.CrashRecovery10Servers.AITServer02.class, Task.TaskType.EXPECT_READY, 480, "server");
		server2.start("Object1", "$(2)");
		Task client1 = createTask("client1", org.jboss.jbossts.qa.CrashRecovery10Clients.Client01a.class, Task.TaskType.EXPECT_PASS_FAIL, 480, "client");
		client1.start("$(2)");
		client1.waitFor();
		server2.terminate();
	}

	@Test public void CrashRecovery10_Test02()
	{
		setTestName("Test02");
		Task server1 = createTask("server1", org.jboss.jbossts.qa.CrashRecovery10Servers.AITServer01.class, Task.TaskType.EXPECT_READY, 480, "server");
		server1.start("Object1", "$(1)");
		Task client0 = createTask("client0", org.jboss.jbossts.qa.CrashRecovery10Clients.Client02b.class, Task.TaskType.EXPECT_PASS_FAIL, 480, "client");
		client0.start("$(1)");
		client0.waitFor();
        server1.terminate();
		Task server2 = createTask("server2", org.jboss.jbossts.qa.CrashRecovery10Servers.AITServer02.class, Task.TaskType.EXPECT_READY, 480, "server");
		server2.start("Object1", "$(2)");
		Task client1 = createTask("client1", org.jboss.jbossts.qa.CrashRecovery10Clients.Client02a.class, Task.TaskType.EXPECT_PASS_FAIL, 480, "client");
		client1.start("$(2)");
		client1.waitFor();
		server2.terminate();
	}

	@Test public void CrashRecovery10_Test03()
	{
		setTestName("Test03");
		Task server1 = createTask("server1", org.jboss.jbossts.qa.CrashRecovery10Servers.AITServer03.class, Task.TaskType.EXPECT_READY, 480, "server");
		server1.start("Object1", "Object2", "$(1)", "$(2)");
		Task client0 = createTask("client0", org.jboss.jbossts.qa.CrashRecovery10Clients.Client03b.class, Task.TaskType.EXPECT_PASS_FAIL, 480, "client");
		client0.start("$(1)", "$(2)");
		client0.waitFor();
        server1.terminate();
		Task server2 = createTask("server2", org.jboss.jbossts.qa.CrashRecovery10Servers.AITServer04.class, Task.TaskType.EXPECT_READY, 480, "server");
		server2.start("Object1", "Object2", "$(3)", "$(4)");
		Task client1 = createTask("client1", org.jboss.jbossts.qa.CrashRecovery10Clients.Client03a.class, Task.TaskType.EXPECT_PASS_FAIL, 480, "client");
		client1.start("$(3)", "$(4)");
		client1.waitFor();
		server2.terminate();
	}

	@Test public void CrashRecovery10_Test04()
	{
		setTestName("Test04");
		Task server1 = createTask("server1", org.jboss.jbossts.qa.CrashRecovery10Servers.AITServer03.class, Task.TaskType.EXPECT_READY, 480, "server");
		server1.start("Object1", "Object2", "$(1)", "$(2)");
		Task client0 = createTask("client0", org.jboss.jbossts.qa.CrashRecovery10Clients.Client04b.class, Task.TaskType.EXPECT_PASS_FAIL, 480, "client");
		client0.start("$(1)", "$(2)");
		client0.waitFor();
        server1.terminate();
		Task server2 = createTask("server2", org.jboss.jbossts.qa.CrashRecovery10Servers.AITServer04.class, Task.TaskType.EXPECT_READY, 480, "server");
		server2.start("Object1", "Object2", "$(3)", "$(4)");
		Task client1 = createTask("client1", org.jboss.jbossts.qa.CrashRecovery10Clients.Client04a.class, Task.TaskType.EXPECT_PASS_FAIL, 480, "client");
		client1.start("$(3)", "$(4)");
		client1.waitFor();
		server2.terminate();
	}

	@Test public void CrashRecovery10_Test05()
	{
		setTestName("Test05");
		Task server1 = createTask("server1", org.jboss.jbossts.qa.CrashRecovery10Servers.AITServer01.class, Task.TaskType.EXPECT_READY, 480, "server_1");
		server1.start("Object1", "$(1)");
		Task server2 = createTask("server2", org.jboss.jbossts.qa.CrashRecovery10Servers.AITServer01.class, Task.TaskType.EXPECT_READY, 480, "server_2");
		server2.start("Object2", "$(2)");
		Task client0 = createTask("client0", org.jboss.jbossts.qa.CrashRecovery10Clients.Client03b.class, Task.TaskType.EXPECT_PASS_FAIL, 480, "client");
		client0.start("$(1)", "$(2)");
		client0.waitFor();
        server2.terminate();
        server1.terminate();
		Task server3 = createTask("server3", org.jboss.jbossts.qa.CrashRecovery10Servers.AITServer02.class, Task.TaskType.EXPECT_READY, 480, "server_1");
		server3.start("Object1", "$(3)");
		Task server4 = createTask("server4", org.jboss.jbossts.qa.CrashRecovery10Servers.AITServer02.class, Task.TaskType.EXPECT_READY, 480, "server_2");
		server4.start("Object2", "$(4)");
		Task client1 = createTask("client1", org.jboss.jbossts.qa.CrashRecovery10Clients.Client03a.class, Task.TaskType.EXPECT_PASS_FAIL, 480, "client");
		client1.start("$(3)", "$(4)");
		client1.waitFor();
		server4.terminate();
		server3.terminate();
	}

	@Test public void CrashRecovery10_Test06()
	{
		setTestName("Test06");
		Task server1 = createTask("server1", org.jboss.jbossts.qa.CrashRecovery10Servers.AITServer01.class, Task.TaskType.EXPECT_READY, 480, "server_1");
		server1.start("Object1", "$(1)");
		Task server2 = createTask("server2", org.jboss.jbossts.qa.CrashRecovery10Servers.AITServer01.class, Task.TaskType.EXPECT_READY, 480, "server_2");
		server2.start("Object2", "$(2)");
		Task client0 = createTask("client0", org.jboss.jbossts.qa.CrashRecovery10Clients.Client04b.class, Task.TaskType.EXPECT_PASS_FAIL, 480, "client");
		client0.start("$(1)", "$(2)");
		client0.waitFor();
        server2.terminate();
        server1.terminate();
		Task server3 = createTask("server3", org.jboss.jbossts.qa.CrashRecovery10Servers.AITServer02.class, Task.TaskType.EXPECT_READY, 480, "server_1");
		server3.start("Object1", "$(3)");
		Task server4 = createTask("server4", org.jboss.jbossts.qa.CrashRecovery10Servers.AITServer02.class, Task.TaskType.EXPECT_READY, 480, "server_2");
		server4.start("Object2", "$(4)");
		Task client1 = createTask("client1", org.jboss.jbossts.qa.CrashRecovery10Clients.Client04a.class, Task.TaskType.EXPECT_PASS_FAIL, 480, "client");
		client1.start("$(3)", "$(4)");
		client1.waitFor();
		server4.terminate();
		server3.terminate();
	}

}