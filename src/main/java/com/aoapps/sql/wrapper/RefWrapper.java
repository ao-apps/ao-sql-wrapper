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

import java.sql.Ref;
import java.sql.SQLException;
import java.util.Map;

/**
 * Wraps a {@link Ref}.
 *
 * @author  AO Industries, Inc.
 */
public interface RefWrapper extends Wrapper, Ref, AutoCloseable {

	/**
	 * Gets the ref that is wrapped.
	 */
	@Override
	Ref getWrapped();

	/**
	 * Releases resources associated with this wrapper.
	 */
	@Override
	default void close() throws SQLException {
		// Do nothing by default
	}

	@Override
	default String getBaseTypeName() throws SQLException {
		return getWrapped().getBaseTypeName();
	}

	@Override
	default Object getObject(Map<String, Class<?>> map) throws SQLException {
		// TODO: How can we wrap SQLData on UDT maps?
		return getWrapped().getObject(map);
	}

	@Override
	default Object getObject() throws SQLException {
		return getWrapped().getObject();
	}

	@Override
	default void setObject(Object value) throws SQLException {
		getWrapped().setObject(value);
	}
}
