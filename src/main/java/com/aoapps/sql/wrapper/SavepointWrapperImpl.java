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

import java.sql.SQLException;
import java.sql.Savepoint;

/**
 * Wraps a {@link Savepoint}.
 *
 * @author  AO Industries, Inc.
 */
public class SavepointWrapperImpl implements SavepointWrapper {

  private final ConnectionWrapperImpl connectionWrapper;
  private final Savepoint wrapped;

  public SavepointWrapperImpl(ConnectionWrapperImpl connectionWrapper, Savepoint wrapped) {
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
  public Savepoint getWrapped() {
    return wrapped;
  }

  @Override
  public String toString() {
    return getWrapped().toString();
  }

  @Override
  public void close() throws SQLException {
    getConnectionWrapper().releaseSavepoint(this);
  }
}
