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

import java.sql.Array;
import java.sql.SQLException;

/**
 * Wraps an {@link Object}.
 *
 * @author  AO Industries, Inc.
 */
public interface Wrapper extends java.sql.Wrapper {

	/**
	 * Gets the wrapper that is wrapped.
	 * <p>
	 * Note: This does not return {@link java.sql.Wrapper} because we use {@link Wrapper} on some objects that are not
	 * themselves {@link java.sql.Wrapper}, such as {@link Array}.
	 * </p>
	 */
	Object getWrapped();

	@Override
	default <T> T unwrap(Class<T> iface) throws SQLException {
		if(iface.isInstance(this)) return iface.cast(this);
		Object wrapped = getWrapped();
		if(iface.isInstance(wrapped)) return iface.cast(wrapped);
		if(wrapped instanceof Wrapper) {
			return ((Wrapper)wrapped).unwrap(iface);
		} else {
			throw new SQLException("Nothing to unwrap for " + iface.getName());
		}
	}

	@Override
	default boolean isWrapperFor(Class<?> iface) throws SQLException {
		if(iface.isInstance(this)) return true;
		Object wrapped = getWrapped();
		if(iface.isInstance(wrapped)) return true;
		if(wrapped instanceof Wrapper) {
			return ((Wrapper)wrapped).isWrapperFor(iface);
		} else {
			return false;
		}
	}
}
