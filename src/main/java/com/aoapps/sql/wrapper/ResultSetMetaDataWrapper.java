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

import java.sql.ResultSetMetaData;
import java.sql.SQLException;

/**
 * Wraps a {@link ResultSetMetaData}.
 *
 * @author  AO Industries, Inc.
 */
public interface ResultSetMetaDataWrapper extends Wrapper, ResultSetMetaData, AutoCloseable {

  /**
   * Gets the result set meta data that is wrapped.
   */
  @Override
  ResultSetMetaData getWrapped();

  /**
   * Releases resources associated with this wrapper.
   */
  @Override
  default void close() throws SQLException {
    // Do nothing by default
  }

  @Override
  default int getColumnCount() throws SQLException {
    return getWrapped().getColumnCount();
  }

  @Override
  default boolean isAutoIncrement(int column) throws SQLException {
    return getWrapped().isAutoIncrement(column);
  }

  @Override
  default boolean isCaseSensitive(int column) throws SQLException {
    return getWrapped().isCaseSensitive(column);
  }

  @Override
  default boolean isSearchable(int column) throws SQLException {
    return getWrapped().isSearchable(column);
  }

  @Override
  default boolean isCurrency(int column) throws SQLException {
    return getWrapped().isCurrency(column);
  }

  @Override
  default int isNullable(int column) throws SQLException {
    return getWrapped().isNullable(column);
  }

  @Override
  default boolean isSigned(int column) throws SQLException {
    return getWrapped().isSigned(column);
  }

  @Override
  default int getColumnDisplaySize(int column) throws SQLException {
    return getWrapped().getColumnDisplaySize(column);
  }

  @Override
  default String getColumnLabel(int column) throws SQLException {
    return getWrapped().getColumnLabel(column);
  }

  @Override
  default String getColumnName(int column) throws SQLException {
    return getWrapped().getColumnName(column);
  }

  @Override
  default String getSchemaName(int column) throws SQLException {
    return getWrapped().getSchemaName(column);
  }

  @Override
  default int getPrecision(int column) throws SQLException {
    return getWrapped().getPrecision(column);
  }

  @Override
  default int getScale(int column) throws SQLException {
    return getWrapped().getScale(column);
  }

  @Override
  default String getTableName(int column) throws SQLException {
    return getWrapped().getTableName(column);
  }

  @Override
  default String getCatalogName(int column) throws SQLException {
    return getWrapped().getCatalogName(column);
  }

  @Override
  default int getColumnType(int column) throws SQLException {
    return getWrapped().getColumnType(column);
  }

  @Override
  default String getColumnTypeName(int column) throws SQLException {
    return getWrapped().getColumnTypeName(column);
  }

  @Override
  default boolean isReadOnly(int column) throws SQLException {
    return getWrapped().isReadOnly(column);
  }

  @Override
  default boolean isWritable(int column) throws SQLException {
    return getWrapped().isWritable(column);
  }

  @Override
  default boolean isDefinitelyWritable(int column) throws SQLException {
    return getWrapped().isDefinitelyWritable(column);
  }

  @Override
  default String getColumnClassName(int column) throws SQLException {
    return getWrapped().getColumnClassName(column);
  }
}
