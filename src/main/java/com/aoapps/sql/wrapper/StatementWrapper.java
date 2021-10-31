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
 * along with ao-sql-wrapper.  If not, see <https://www.gnu.org/licenses/>.
 */
package com.aoapps.sql.wrapper;

import java.sql.SQLException;
import java.sql.SQLWarning;
import java.sql.Statement;

/**
 * Wraps a {@link Statement}.
 *
 * @author  AO Industries, Inc.
 */
public interface StatementWrapper extends Wrapper, Statement {

	/**
	 * Gets the statement that is wrapped.
	 */
	@Override
	Statement getWrapped();

	@Override
	ResultSetWrapper executeQuery(String sql) throws SQLException;

	@Override
	default int executeUpdate(String sql) throws SQLException {
		return getWrapped().executeUpdate(sql);
	}

	@Override
	default void close() throws SQLException {
		getWrapped().close();
	}

	@Override
	default int getMaxFieldSize() throws SQLException {
		return getWrapped().getMaxFieldSize();
	}

	@Override
	default void setMaxFieldSize(int max) throws SQLException {
		getWrapped().setMaxFieldSize(max);
	}

	@Override
	default int getMaxRows() throws SQLException {
		return getWrapped().getMaxRows();
	}

	@Override
	default void setMaxRows(int max) throws SQLException {
		getWrapped().setMaxRows(max);
	}

	@Override
	default void setEscapeProcessing(boolean enable) throws SQLException {
		getWrapped().setEscapeProcessing(enable);
	}

	@Override
	default int getQueryTimeout() throws SQLException {
		return getWrapped().getQueryTimeout();
	}

	@Override
	default void setQueryTimeout(int seconds) throws SQLException {
		getWrapped().setQueryTimeout(seconds);
	}

	@Override
	default void cancel() throws SQLException {
		getWrapped().cancel();
	}

	@Override
	default SQLWarning getWarnings() throws SQLException {
		return getWrapped().getWarnings();
	}

	@Override
	default void clearWarnings() throws SQLException {
		getWrapped().clearWarnings();
	}

	@Override
	default void setCursorName(String name) throws SQLException {
		getWrapped().setCursorName(name);
	}

	@Override
	default boolean execute(String sql) throws SQLException {
		return getWrapped().execute(sql);
	}

	@Override
	ResultSetWrapper getResultSet() throws SQLException;

	@Override
	default int getUpdateCount() throws SQLException {
		return getWrapped().getUpdateCount();
	}

	@Override
	default boolean getMoreResults() throws SQLException {
		return getWrapped().getMoreResults();
	}

	@Override
	default void setFetchDirection(int direction) throws SQLException {
		getWrapped().setFetchDirection(direction);
	}

	@Override
	default int getFetchDirection() throws SQLException {
		return getWrapped().getFetchDirection();
	}

	@Override
	default void setFetchSize(int rows) throws SQLException {
		getWrapped().setFetchSize(rows);
	}

	@Override
	default int getFetchSize() throws SQLException {
		return getWrapped().getFetchSize();
	}

	@Override
	default int getResultSetConcurrency() throws SQLException {
		return getWrapped().getResultSetConcurrency();
	}

	@Override
	default int getResultSetType() throws SQLException {
		return getWrapped().getResultSetType();
	}

	@Override
	default void addBatch(String sql) throws SQLException {
		getWrapped().addBatch(sql);
	}

	@Override
	default void clearBatch() throws SQLException {
		getWrapped().clearBatch();
	}

	@Override
	default int[] executeBatch() throws SQLException {
		return getWrapped().executeBatch();
	}

	@Override
	ConnectionWrapper getConnection() throws SQLException;

	@Override
	default boolean getMoreResults(int current) throws SQLException {
		return getWrapped().getMoreResults(current);
	}

	@Override
	ResultSetWrapper getGeneratedKeys() throws SQLException;

	@Override
	default int executeUpdate(String sql, int autoGeneratedKeys) throws SQLException {
		return getWrapped().executeUpdate(sql, autoGeneratedKeys);
	}

	@Override
	default int executeUpdate(String sql, int[] columnIndexes) throws SQLException {
		return getWrapped().executeUpdate(sql, columnIndexes);
	}

	@Override
	default int executeUpdate(String sql, String[] columnNames) throws SQLException {
		return getWrapped().executeUpdate(sql, columnNames);
	}

	@Override
	default boolean execute(String sql, int autoGeneratedKeys) throws SQLException {
		return getWrapped().execute(sql, autoGeneratedKeys);
	}

	@Override
	default boolean execute(String sql, int[] columnIndexes) throws SQLException {
		return getWrapped().execute(sql, columnIndexes);
	}

	@Override
	default boolean execute(String sql, String[] columnNames) throws SQLException {
		return getWrapped().execute(sql, columnNames);
	}

	@Override
	default int getResultSetHoldability() throws SQLException {
		return getWrapped().getResultSetHoldability();
	}

	@Override
	default boolean isClosed() throws SQLException {
		return getWrapped().isClosed();
	}

	@Override
	default void setPoolable(boolean poolable) throws SQLException {
		getWrapped().setPoolable(poolable);
	}

	@Override
	default boolean isPoolable() throws SQLException {
		return getWrapped().isPoolable();
	}

	@Override
	default void closeOnCompletion() throws SQLException {
		getWrapped().closeOnCompletion();
	}

	@Override
	default boolean isCloseOnCompletion() throws SQLException {
		return getWrapped().isCloseOnCompletion();
	}

	@Override
	default long getLargeUpdateCount() throws SQLException {
		return getWrapped().getLargeUpdateCount();
	}

	@Override
	default void setLargeMaxRows(long max) throws SQLException {
		getWrapped().setLargeMaxRows(max);
	}

	@Override
	default long getLargeMaxRows() throws SQLException {
		return getWrapped().getLargeMaxRows();
	}

	@Override
	default long[] executeLargeBatch() throws SQLException {
		return getWrapped().executeLargeBatch();
	}

	@Override
	default long executeLargeUpdate(String sql) throws SQLException {
		return getWrapped().executeLargeUpdate(sql);
	}

	@Override
	default long executeLargeUpdate(String sql, int autoGeneratedKeys) throws SQLException {
		return getWrapped().executeLargeUpdate(sql, autoGeneratedKeys);
	}

	@Override
	default long executeLargeUpdate(String sql, int[] columnIndexes) throws SQLException {
		return getWrapped().executeLargeUpdate(sql, columnIndexes);
	}

	@Override
	default long executeLargeUpdate(String sql, String[] columnNames) throws SQLException {
		return getWrapped().executeLargeUpdate(sql, columnNames);
	}

	// Java 9: String enquoteLiteral(String val)  throws SQLException;
	// Java 9: String enquoteIdentifier(String identifier, boolean alwaysQuote) throws SQLException
	// Java 9: boolean isSimpleIdentifier(String identifier) throws SQLException
	// Java 9: String enquoteNCharLiteral(String val)  throws SQLException
}
