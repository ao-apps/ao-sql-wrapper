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

import java.sql.RowId;
import java.sql.SQLException;

/**
 * Wraps a {@link RowId}.
 *
 * @author  AO Industries, Inc.
 */
public interface RowIdWrapper extends Wrapper, RowId, AutoCloseable {

	/**
	 * Gets the row ID that is wrapped.
	 */
	@Override
	RowId getWrapped();

	/**
	 * Releases resources associated with this wrapper.
	 */
	@Override
	default void close() throws SQLException {
		// Do nothing by default
	}

	@Override
	boolean equals(Object obj);

	@Override
	default byte[] getBytes() {
		return getWrapped().getBytes();
	}

	@Override
	String toString();

	@Override
	int hashCode();
}
