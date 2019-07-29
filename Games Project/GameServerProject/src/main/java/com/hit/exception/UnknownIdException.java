package com.hit.exception;

public class UnknownIdException
extends java.lang.Exception
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public UnknownIdException(java.lang.Throwable err)
	{
		super(err);
		
	}
	public UnknownIdException(java.lang.Throwable err, java.lang.String message) 
	{
		super(message,err);
	}
}