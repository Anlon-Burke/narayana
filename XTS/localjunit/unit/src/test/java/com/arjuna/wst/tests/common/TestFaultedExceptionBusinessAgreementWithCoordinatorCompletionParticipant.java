/*
   Copyright The Narayana Authors
   SPDX short identifier: Apache-2.0
 */



package com.arjuna.wst.tests.common;

import com.arjuna.wst.BusinessAgreementWithCoordinatorCompletionParticipant;
import com.arjuna.wst.FaultedException;
import com.arjuna.wst.Status;
import com.arjuna.wst.SystemException;
import com.arjuna.wst.WrongStateException;

public class TestFaultedExceptionBusinessAgreementWithCoordinatorCompletionParticipant implements BusinessAgreementWithCoordinatorCompletionParticipant
{

    public void close () throws WrongStateException, SystemException
    {
    }
    
    public void cancel () throws WrongStateException, SystemException
    {
    }

    public void compensate () throws FaultedException, WrongStateException, SystemException
    {
	throw new FaultedException();
    }
    
    public String status () throws SystemException
    {
	return Status.STATUS_ACTIVE;
    }

    public void forget () throws WrongStateException, SystemException
    {
    }

    public void complete () throws WrongStateException, SystemException
    {
    }
    
    public void unknown () throws SystemException
    {
    }

    public void error () throws SystemException
    {
    }

}