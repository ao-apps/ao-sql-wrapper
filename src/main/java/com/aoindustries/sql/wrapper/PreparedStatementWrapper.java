/*
 * ao-sql-wrapper - JDBC API wrapper.
 * Copyright (C) 2020  AO Industries, Inc.
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
package com.aoindustries.sql.wrapper;

import java.io.InputStream;
import java.io.Reader;
import java.math.BigDecimal;
import java.net.URL;
import java.sql.Array;
import java.sql.Blob;
import java.sql.Clob;
import java.sql.Date;
import java.sql.NClob;
import java.sql.PreparedStatement;
import java.sql.Ref;
import java.sql.RowId;
import java.sql.SQLException;
import java.sql.SQLType;
import java.sql.SQLXML;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Calendar;

/**
 * Wraps a {@link PreparedStatement}.
 *
 * @author  AO Industries, Inc.
 */
public interface PreparedStatementWrapper extends StatementWrapper, PreparedStatement {

	/**
	 * Gets the prepared statement that is wrapped.
	 */
	@Override
	PreparedStatement getWrapped();

	@Override
	ResultSetWrapper executeQuery() throws SQLException;

	@Override
	default int executeUpdate() throws SQLException {
		return getWrapped().executeUpdate();
	}

	@Override
	default void setNull(int parameterIndex, int sqlType) throws SQLException {
		getWrapped().setNull(parameterIndex, sqlType);
	}

	@Override
	default void setBoolean(int parameterIndex, boolean x) throws SQLException {
		getWrapped().setBoolean(parameterIndex, x);
	}

	@Override
	default void setByte(int parameterIndex, byte x) throws SQLException {
		getWrapped().setByte(parameterIndex, x);
	}

	@Override
	default void setShort(int parameterIndex, short x) throws SQLException {
		getWrapped().setShort(parameterIndex, x);
	}

	@Override
	default void setInt(int parameterIndex, int x) throws SQLException {
		getWrapped().setInt(parameterIndex, x);
	}

	@Override
	default void setLong(int parameterIndex, long x) throws SQLException {
		getWrapped().setLong(parameterIndex, x);
	}

	@Override
	default void setFloat(int parameterIndex, float x) throws SQLException {
		getWrapped().setFloat(parameterIndex, x);
	}

	@Override
	default void setDouble(int parameterIndex, double x) throws SQLException {
		getWrapped().setDouble(parameterIndex, x);
	}

	@Override
	default void setBigDecimal(int parameterIndex, BigDecimal x) throws SQLException {
		getWrapped().setBigDecimal(parameterIndex, x);
	}

	@Override
	default void setString(int parameterIndex, String x) throws SQLException {
		getWrapped().setString(parameterIndex, x);
	}

	@Override
	default void setBytes(int parameterIndex, byte x[]) throws SQLException {
		getWrapped().setBytes(parameterIndex, x);
	}

	@Override
	default void setDate(int parameterIndex, Date x) throws SQLException {
		getWrapped().setDate(parameterIndex, x);
	}

	@Override
	default void setTime(int parameterIndex, Time x) throws SQLException {
		getWrapped().setTime(parameterIndex, x);
	}

	@Override
	default void setTimestamp(int parameterIndex, Timestamp x) throws SQLException {
		getWrapped().setTimestamp(parameterIndex, x);
	}

	@Override
	void setAsciiStream(int parameterIndex, InputStream x, int length) throws SQLException;

	@Override
	@Deprecated // Java 9: (since="1.2")
	void setUnicodeStream(int parameterIndex, InputStream x, int length) throws SQLException;

	@Override
	void setBinaryStream(int parameterIndex, InputStream x, int length) throws SQLException;

	@Override
	default void clearParameters() throws SQLException {
		getWrapped().clearParameters();
	}

	@Override
	default void setObject(int parameterIndex, Object x, int targetSqlType) throws SQLException {
		getWrapped().setObject(parameterIndex, x, targetSqlType);
	}

	@Override
	default void setObject(int parameterIndex, Object x) throws SQLException {
		getWrapped().setObject(parameterIndex, x);
	}

	@Override
	default boolean execute() throws SQLException {
		return getWrapped().execute();
	}

	@Override
	default void addBatch() throws SQLException {
		getWrapped().addBatch();
	}

	@Override
	void setCharacterStream(int parameterIndex, Reader reader, int length) throws SQLException;

	@Override
	void setRef(int parameterIndex, Ref x) throws SQLException;

	@Override
	void setBlob(int parameterIndex, Blob x) throws SQLException;

	@Override
	void setClob(int parameterIndex, Clob x) throws SQLException;

	@Override
	void setArray(int parameterIndex, Array x) throws SQLException;

	@Override
	ResultSetMetaDataWrapper getMetaData() throws SQLException;

	@Override
	default void setDate(int parameterIndex, Date x, Calendar cal) throws SQLException {
		getWrapped().setDate(parameterIndex, x, cal);
	}

	@Override
	default void setTime(int parameterIndex, Time x, Calendar cal) throws SQLException {
		getWrapped().setTime(parameterIndex, x, cal);
	}

	@Override
	default void setTimestamp(int parameterIndex, Timestamp x, Calendar cal) throws SQLException {
		getWrapped().setTimestamp(parameterIndex, x, cal);
	}

	@Override
	default void setNull (int parameterIndex, int sqlType, String typeName) throws SQLException {
		getWrapped().setNull(parameterIndex, sqlType, typeName);
	}

	@Override
	default void setURL(int parameterIndex, URL x) throws SQLException {
		getWrapped().setURL(parameterIndex, x);
	}

	@Override
	ParameterMetaDataWrapper getParameterMetaData() throws SQLException;

	@Override
	void setRowId(int parameterIndex, RowId x) throws SQLException;

	@Override
	default void setNString(int parameterIndex, String value) throws SQLException {
		getWrapped().setNString(parameterIndex, value);
	}

	@Override
	void setNCharacterStream(int parameterIndex, Reader value, long length) throws SQLException;

	@Override
	void setNClob(int parameterIndex, NClob value) throws SQLException;

	@Override
	void setClob(int parameterIndex, Reader reader, long length) throws SQLException;

	@Override
	void setBlob(int parameterIndex, InputStream inputStream, long length) throws SQLException;

	@Override
	void setNClob(int parameterIndex, Reader reader, long length) throws SQLException;

	@Override
	void setSQLXML(int parameterIndex, SQLXML xmlObject) throws SQLException;

	@Override
	default void setObject(int parameterIndex, Object x, int targetSqlType, int scaleOrLength) throws SQLException {
		getWrapped().setObject(parameterIndex, x, targetSqlType, scaleOrLength);
	}

	@Override
	void setAsciiStream(int parameterIndex, InputStream x, long length) throws SQLException;

	@Override
	void setBinaryStream(int parameterIndex, InputStream x, long length) throws SQLException;

	@Override
	void setCharacterStream(int parameterIndex, Reader reader, long length) throws SQLException;

	@Override
	void setAsciiStream(int parameterIndex, InputStream x) throws SQLException;

	@Override
	void setBinaryStream(int parameterIndex, InputStream x) throws SQLException;

	@Override
	void setCharacterStream(int parameterIndex, Reader reader) throws SQLException;

	@Override
	void setNCharacterStream(int parameterIndex, Reader value) throws SQLException;

	@Override
	void setClob(int parameterIndex, Reader reader) throws SQLException;

	@Override
	void setBlob(int parameterIndex, InputStream inputStream) throws SQLException;

	@Override
	void setNClob(int parameterIndex, Reader reader) throws SQLException;

	@Override
	default void setObject(int parameterIndex, Object x, SQLType targetSqlType, int scaleOrLength) throws SQLException {
		getWrapped().setObject(parameterIndex, x, targetSqlType, scaleOrLength);
	}

	@Override
	default void setObject(int parameterIndex, Object x, SQLType targetSqlType) throws SQLException {
		getWrapped().setObject(parameterIndex, x, targetSqlType);
	}

	@Override
	default long executeLargeUpdate() throws SQLException {
		return getWrapped().executeLargeUpdate();
	}
}
