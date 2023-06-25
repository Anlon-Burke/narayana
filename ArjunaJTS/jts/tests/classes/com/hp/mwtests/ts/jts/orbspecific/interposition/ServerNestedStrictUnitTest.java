/*
   Copyright The Narayana Authors
   SPDX short identifier: Apache-2.0
 */



package com.hp.mwtests.ts.jts.orbspecific.interposition;

import static org.junit.Assert.assertFalse;

import org.junit.Test;
import org.omg.CosTransactions.Control;

import com.arjuna.ats.internal.jts.orbspecific.ControlImple;
import com.arjuna.ats.internal.jts.orbspecific.coordinator.ArjunaTransactionImple;
import com.arjuna.ats.internal.jts.orbspecific.interposition.ServerControl;
import com.arjuna.ats.internal.jts.orbspecific.interposition.resources.strict.ServerStrictNestedAction;
import com.hp.mwtests.ts.jts.resources.TestBase;

public class ServerNestedStrictUnitTest extends TestBase
{
    @Test
    public void testCommit () throws Exception
    {
        ControlImple cont = new ControlImple(null, null);
        Control theControl = cont.getControl();
        ArjunaTransactionImple tx = cont.getImplHandle();
        ServerControl sc = new ServerControl(tx.get_uid(), theControl, tx, theControl.get_coordinator(), theControl.get_terminator()); 
        ServerStrictNestedAction act = new ServerStrictNestedAction(sc, true);
        
        assertFalse(act.interposeResource());
        
        act.commit_subtransaction(null);
    }
    
    @Test
    public void testRollback () throws Exception
    {
        ControlImple cont = new ControlImple(null, null);
        Control theControl = cont.getControl();
        ArjunaTransactionImple tx = cont.getImplHandle();
        ServerControl sc = new ServerControl(tx.get_uid(), theControl, tx, theControl.get_coordinator(), theControl.get_terminator()); 
        ServerStrictNestedAction act = new ServerStrictNestedAction(sc, true);
        
        act.rollback_subtransaction();
    }
}