/*
 * ao-sql-wrapper - JDBC API wrapper.
 * Copyright (C) 2020, 2021, 2022  AO Industries, Inc.
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
 * along with ao-sql-wrapper.  If not, see <https://www.gnu.org/licenses/>.
 */

package com.aoapps.sql.wrapper;

import java.sql.Array;
import java.sql.SQLException;
import java.util.Map;

/**
 * Wraps an {@link Array}.
 *
 * @author  AO Industries, Inc.
 */
public interface ArrayWrapper extends Wrapper, Array, AutoCloseable {

	/**
	 * Gets the array that is wrapped.
	 */
	@Override
	Array getWrapped();

	/**
	 * Calls {@link #free()}
	 *
	 * @see  #free()
	 */
	@Override
	default void close() throws SQLException {
		free();
	}

	@Override
	default String getBaseTypeName() throws SQLException {
		return getWrapped().getBaseTypeName();
	}

	@Override
	default int getBaseType() throws SQLException {
		return getWrapped().getBaseType();
	}

	@Override
	default Object getArray() throws SQLException {
		return getWrapped().getArray();
	}

	@Override
	default Object getArray(Map<String, Class<?>> map) throws SQLException {
		// TODO: How can we wrap SQLData on UDT maps?
		return getWrapped().getArray(map);
	}

	@Override
	default Object getArray(long index, int count) throws SQLException {
		return getWrapped().getArray(index, count);
	}

	@Override
	default Object getArray(long index, int count, Map<String, Class<?>> map) throws SQLException {
		// TODO: How can we wrap SQLData on UDT maps?
		return getWrapped().getArray(index, count, map);
	}

	@Override
	ResultSetWrapper getResultSet() throws SQLException;

	@Override
	ResultSetWrapper getResultSet(Map<String, Class<?>> map) throws SQLException;

	@Override
	ResultSetWrapper getResultSet(long index, int count) throws SQLException;

	@Override
	ResultSetWrapper getResultSet(long index, int count, Map<String, Class<?>> map) throws SQLException;

	@Override
	default void free() throws SQLException {
		getWrapped().free();
	}
}
