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

import java.sql.ParameterMetaData;
import java.sql.SQLException;

/**
 * Wraps a {@link ParameterMetaData}.
 *
 * @author  AO Industries, Inc.
 */
public interface ParameterMetaDataWrapper extends Wrapper, ParameterMetaData, AutoCloseable {

	/**
	 * Gets the parameter meta data that is wrapped.
	 */
	@Override
	ParameterMetaData getWrapped();

	/**
	 * Releases resources associated with this wrapper.
	 */
	@Override
	default void close() throws SQLException {
		// Do nothing by default
	}

	@Override
	default int getParameterCount() throws SQLException {
		return getWrapped().getParameterCount();
	}

	@Override
	default int isNullable(int param) throws SQLException {
		return getWrapped().isNullable(param);
	}

	@Override
	default boolean isSigned(int param) throws SQLException {
		return getWrapped().isSigned(param);
	}

	@Override
	default int getPrecision(int param) throws SQLException {
		return getWrapped().getPrecision(param);
	}

	@Override
	default int getScale(int param) throws SQLException {
		return getWrapped().getScale(param);
	}

	@Override
	default int getParameterType(int param) throws SQLException {
		return getWrapped().getParameterType(param);
	}

	@Override
	default String getParameterTypeName(int param) throws SQLException {
		return getWrapped().getParameterTypeName(param);
	}

	@Override
	default String getParameterClassName(int param) throws SQLException {
		return getWrapped().getParameterClassName(param);
	}

	@Override
	default int getParameterMode(int param) throws SQLException {
		return getWrapped().getParameterMode(param);
	}
}
