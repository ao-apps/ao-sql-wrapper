/*
 * ao-sql-wrapper - JDBC API wrapper.
 * Copyright (C) 2020, 2021  AO Industries, Inc.
 *     support@aoindustries.com
 *     7262 Bull Pen Cir
 *     Mobile, AL 36695
 *
 * This file is part of ao-sql-wrapper.
 *
 * ao-sql-wrapper is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * ao-sql-wrapper is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with ao-sql-wrapper.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.aoapps.sql.wrapper;

import java.sql.RowId;

/**
 * Wraps a {@link RowId}.
 *
 * @author  AO Industries, Inc.
 */
public class RowIdWrapperImpl implements RowIdWrapper {

	private final ConnectionWrapperImpl connectionWrapper;
	private final RowId wrapped;

	public RowIdWrapperImpl(ConnectionWrapperImpl connectionWrapper, RowId wrapped) {
		this.connectionWrapper = connectionWrapper;
		this.wrapped = wrapped;
	}

	/**
	 * Gets the connection wrapper.
	 */
	protected ConnectionWrapperImpl getConnectionWrapper() {
		return connectionWrapper;
	}

	@Override
	public RowId getWrapped() {
		return wrapped;
	}

	/**
	 * Unwraps a {@link RowId}, if wrapped by this wrapper.
	 *
	 * @see  ConnectionWrapperImpl#unwrapRowId(java.sql.RowId)
	 */
	protected RowId unwrapRowId(RowId rowId) {
		return getConnectionWrapper().unwrapRowId(rowId);
	}

	@Override
	public boolean equals(Object obj) {
		if(obj instanceof RowId) {
			obj = unwrapRowId((RowId)obj);
		}
		return getWrapped().equals(obj);
	}

	@Override
	public String toString() {
		return getWrapped().toString();
	}

	@Override
	public int hashCode() {
		return getWrapped().hashCode();
	}
}
