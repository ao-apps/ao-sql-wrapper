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

import java.io.InputStream;
import java.io.Reader;
import java.math.BigDecimal;
import java.net.URL;
import java.sql.Array;
import java.sql.Blob;
import java.sql.Clob;
import java.sql.Date;
import java.sql.NClob;
import java.sql.Ref;
import java.sql.ResultSet;
import java.sql.RowId;
import java.sql.SQLException;
import java.sql.SQLType;
import java.sql.SQLWarning;
import java.sql.SQLXML;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Map;

/**
 * Wraps a {@link ResultSet}.
 *
 * @author  AO Industries, Inc.
 */
public interface ResultSetWrapper extends Wrapper, ResultSet {

	/**
	 * Gets the results that are wrapped.
	 */
	@Override
	ResultSet getWrapped();

	@Override
	default boolean next() throws SQLException {
		return getWrapped().next();
	}

	@Override
	default void close() throws SQLException {
		getWrapped().close();
	}

	@Override
	default boolean wasNull() throws SQLException {
		return getWrapped().wasNull();
	}

	@Override
	default String getString(int columnIndex) throws SQLException {
		return getWrapped().getString(columnIndex);
	}

	@Override
	default boolean getBoolean(int columnIndex) throws SQLException {
		return getWrapped().getBoolean(columnIndex);
	}

	@Override
	default byte getByte(int columnIndex) throws SQLException {
		return getWrapped().getByte(columnIndex);
	}

	@Override
	default short getShort(int columnIndex) throws SQLException {
		return getWrapped().getShort(columnIndex);
	}

	@Override
	default int getInt(int columnIndex) throws SQLException {
		return getWrapped().getInt(columnIndex);
	}

	@Override
	default long getLong(int columnIndex) throws SQLException {
		return getWrapped().getLong(columnIndex);
	}

	@Override
	default float getFloat(int columnIndex) throws SQLException {
		return getWrapped().getFloat(columnIndex);
	}

	@Override
	default double getDouble(int columnIndex) throws SQLException {
		return getWrapped().getDouble(columnIndex);
	}

	@Override
	@Deprecated // Java 9: (since="1.2")
	default BigDecimal getBigDecimal(int columnIndex, int scale) throws SQLException {
		return getWrapped().getBigDecimal(columnIndex, scale);
	}

	@Override
	default byte[] getBytes(int columnIndex) throws SQLException {
		return getWrapped().getBytes(columnIndex);
	}

	@Override
	default Date getDate(int columnIndex) throws SQLException {
		return getWrapped().getDate(columnIndex);
	}

	@Override
	default Time getTime(int columnIndex) throws SQLException {
		return getWrapped().getTime(columnIndex);
	}

	@Override
	default Timestamp getTimestamp(int columnIndex) throws SQLException {
		return getWrapped().getTimestamp(columnIndex);
	}

	@Override
	InputStreamWrapper getAsciiStream(int columnIndex) throws SQLException;

	@Override
	@Deprecated // Java 9: (since="1.2")
	InputStreamWrapper getUnicodeStream(int columnIndex) throws SQLException;

	@Override
	InputStreamWrapper getBinaryStream(int columnIndex) throws SQLException;

	@Override
	default String getString(String columnLabel) throws SQLException {
		return getWrapped().getString(columnLabel);
	}

	@Override
	default boolean getBoolean(String columnLabel) throws SQLException {
		return getWrapped().getBoolean(columnLabel);
	}

	@Override
	default byte getByte(String columnLabel) throws SQLException {
		return getWrapped().getByte(columnLabel);
	}

	@Override
	default short getShort(String columnLabel) throws SQLException {
		return getWrapped().getShort(columnLabel);
	}

	@Override
	default int getInt(String columnLabel) throws SQLException {
		return getWrapped().getInt(columnLabel);
	}

	@Override
	default long getLong(String columnLabel) throws SQLException {
		return getWrapped().getLong(columnLabel);
	}

	@Override
	default float getFloat(String columnLabel) throws SQLException {
		return getWrapped().getFloat(columnLabel);
	}

	@Override
	default double getDouble(String columnLabel) throws SQLException {
		return getWrapped().getDouble(columnLabel);
	}

	@Override
	@Deprecated // Java 9: (since="1.2")
	default BigDecimal getBigDecimal(String columnLabel, int scale) throws SQLException {
		return getWrapped().getBigDecimal(columnLabel, scale);
	}

	@Override
	default byte[] getBytes(String columnLabel) throws SQLException {
		return getWrapped().getBytes(columnLabel);
	}

	@Override
	default Date getDate(String columnLabel) throws SQLException {
		return getWrapped().getDate(columnLabel);
	}

	@Override
	default Time getTime(String columnLabel) throws SQLException {
		return getWrapped().getTime(columnLabel);
	}

	@Override
	default Timestamp getTimestamp(String columnLabel) throws SQLException {
		return getWrapped().getTimestamp(columnLabel);
	}

	@Override
	InputStreamWrapper getAsciiStream(String columnLabel) throws SQLException;

	@Override
	@Deprecated // Java 9: (since="1.2")
	InputStreamWrapper getUnicodeStream(String columnLabel) throws SQLException;

	@Override
	InputStreamWrapper getBinaryStream(String columnLabel) throws SQLException;

	@Override
	default SQLWarning getWarnings() throws SQLException {
		return getWrapped().getWarnings();
	}

	@Override
	default void clearWarnings() throws SQLException {
		getWrapped().clearWarnings();
	}

	@Override
	default String getCursorName() throws SQLException {
		return getWrapped().getCursorName();
	}

	@Override
	ResultSetMetaDataWrapper getMetaData() throws SQLException;

	@Override
	default Object getObject(int columnIndex) throws SQLException {
		return getWrapped().getObject(columnIndex);
	}

	@Override
	default Object getObject(String columnLabel) throws SQLException {
		return getWrapped().getObject(columnLabel);
	}

	@Override
	default int findColumn(String columnLabel) throws SQLException {
		return getWrapped().findColumn(columnLabel);
	}

	@Override
	ReaderWrapper getCharacterStream(int columnIndex) throws SQLException;

	@Override
	ReaderWrapper getCharacterStream(String columnLabel) throws SQLException;

	@Override
	default BigDecimal getBigDecimal(int columnIndex) throws SQLException {
		return getWrapped().getBigDecimal(columnIndex);
	}

	@Override
	default BigDecimal getBigDecimal(String columnLabel) throws SQLException {
		return getWrapped().getBigDecimal(columnLabel);
	}

	@Override
	default boolean isBeforeFirst() throws SQLException {
		return getWrapped().isBeforeFirst();
	}

	@Override
	default boolean isAfterLast() throws SQLException {
		return getWrapped().isAfterLast();
	}

	@Override
	default boolean isFirst() throws SQLException {
		return getWrapped().isFirst();
	}

	@Override
	default boolean isLast() throws SQLException {
		return getWrapped().isLast();
	}

	@Override
	default void beforeFirst() throws SQLException {
		getWrapped().beforeFirst();
	}

	@Override
	default void afterLast() throws SQLException {
		getWrapped().afterLast();
	}

	@Override
	default boolean first() throws SQLException {
		return getWrapped().first();
	}

	@Override
	default boolean last() throws SQLException {
		return getWrapped().last();
	}

	@Override
	default int getRow() throws SQLException {
		return getWrapped().getRow();
	}

	@Override
	default boolean absolute(int row) throws SQLException {
		return getWrapped().absolute(row);
	}

	@Override
	default boolean relative(int rows) throws SQLException {
		return getWrapped().relative(rows);
	}

	@Override
	default boolean previous() throws SQLException {
		return getWrapped().previous();
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
	default int getType() throws SQLException {
		return getWrapped().getType();
	}

	@Override
	default int getConcurrency() throws SQLException {
		return getWrapped().getConcurrency();
	}

	@Override
	default boolean rowUpdated() throws SQLException {
		return getWrapped().rowUpdated();
	}

	@Override
	default boolean rowInserted() throws SQLException {
		return getWrapped().rowInserted();
	}

	@Override
	default boolean rowDeleted() throws SQLException {
		return getWrapped().rowDeleted();
	}

	@Override
	default void updateNull(int columnIndex) throws SQLException {
		getWrapped().updateNull(columnIndex);
	}

	@Override
	default void updateBoolean(int columnIndex, boolean x) throws SQLException {
		getWrapped().updateBoolean(columnIndex, x);
	}

	@Override
	default void updateByte(int columnIndex, byte x) throws SQLException {
		getWrapped().updateByte(columnIndex, x);
	}

	@Override
	default void updateShort(int columnIndex, short x) throws SQLException {
		getWrapped().updateShort(columnIndex, x);
	}

	@Override
	default void updateInt(int columnIndex, int x) throws SQLException {
		getWrapped().updateInt(columnIndex, x);
	}

	@Override
	default void updateLong(int columnIndex, long x) throws SQLException {
		getWrapped().updateLong(columnIndex, x);
	}

	@Override
	default void updateFloat(int columnIndex, float x) throws SQLException {
		getWrapped().updateFloat(columnIndex, x);
	}

	@Override
	default void updateDouble(int columnIndex, double x) throws SQLException {
		getWrapped().updateDouble(columnIndex, x);
	}

	@Override
	default void updateBigDecimal(int columnIndex, BigDecimal x) throws SQLException {
		getWrapped().updateBigDecimal(columnIndex, x);
	}

	@Override
	default void updateString(int columnIndex, String x) throws SQLException {
		getWrapped().updateString(columnIndex, x);
	}

	@Override
	default void updateBytes(int columnIndex, byte[] x) throws SQLException {
		getWrapped().updateBytes(columnIndex, x);
	}

	@Override
	default void updateDate(int columnIndex, Date x) throws SQLException {
		getWrapped().updateDate(columnIndex, x);
	}

	@Override
	default void updateTime(int columnIndex, Time x) throws SQLException {
		getWrapped().updateTime(columnIndex, x);
	}

	@Override
	default void updateTimestamp(int columnIndex, Timestamp x) throws SQLException {
		getWrapped().updateTimestamp(columnIndex, x);
	}

	@Override
	void updateAsciiStream(int columnIndex, InputStream x, int length) throws SQLException;

	@Override
	void updateBinaryStream(int columnIndex, InputStream x, int length) throws SQLException;

	@Override
	void updateCharacterStream(int columnIndex, Reader x, int length) throws SQLException;

	@Override
	default void updateObject(int columnIndex, Object x, int scaleOrLength) throws SQLException {
		getWrapped().updateObject(columnIndex, x, scaleOrLength);
	}

	@Override
	default void updateObject(int columnIndex, Object x) throws SQLException {
		getWrapped().updateObject(columnIndex, x);
	}

	@Override
	default void updateNull(String columnLabel) throws SQLException {
		getWrapped().updateNull(columnLabel);
	}

	@Override
	default void updateBoolean(String columnLabel, boolean x) throws SQLException {
		getWrapped().updateBoolean(columnLabel, x);
	}

	@Override
	default void updateByte(String columnLabel, byte x) throws SQLException {
		getWrapped().updateByte(columnLabel, x);
	}

	@Override
	default void updateShort(String columnLabel, short x) throws SQLException {
		getWrapped().updateShort(columnLabel, x);
	}

	@Override
	default void updateInt(String columnLabel, int x) throws SQLException {
		getWrapped().updateInt(columnLabel, x);
	}

	@Override
	default void updateLong(String columnLabel, long x) throws SQLException {
		getWrapped().updateLong(columnLabel, x);
	}

	@Override
	default void updateFloat(String columnLabel, float x) throws SQLException {
		getWrapped().updateFloat(columnLabel, x);
	}

	@Override
	default void updateDouble(String columnLabel, double x) throws SQLException {
		getWrapped().updateDouble(columnLabel, x);
	}

	@Override
	default void updateBigDecimal(String columnLabel, BigDecimal x) throws SQLException {
		getWrapped().updateBigDecimal(columnLabel, x);
	}

	@Override
	default void updateString(String columnLabel, String x) throws SQLException {
		getWrapped().updateString(columnLabel, x);
	}

	@Override
	default void updateBytes(String columnLabel, byte[] x) throws SQLException {
		getWrapped().updateBytes(columnLabel, x);
	}

	@Override
	default void updateDate(String columnLabel, Date x) throws SQLException {
		getWrapped().updateDate(columnLabel, x);
	}

	@Override
	default void updateTime(String columnLabel, Time x) throws SQLException {
		getWrapped().updateTime(columnLabel, x);
	}

	@Override
	default void updateTimestamp(String columnLabel, Timestamp x) throws SQLException {
		getWrapped().updateTimestamp(columnLabel, x);
	}

	@Override
	void updateAsciiStream(String columnLabel, InputStream x, int length) throws SQLException;

	@Override
	void updateBinaryStream(String columnLabel, InputStream x, int length) throws SQLException;

	@Override
	void updateCharacterStream(String columnLabel, Reader reader, int length) throws SQLException;

	@Override
	default void updateObject(String columnLabel, Object x, int scaleOrLength) throws SQLException {
		getWrapped().updateObject(columnLabel, x, scaleOrLength);
	}

	@Override
	default void updateObject(String columnLabel, Object x) throws SQLException {
		getWrapped().updateObject(columnLabel, x);
	}

	@Override
	default void insertRow() throws SQLException {
		getWrapped().insertRow();
	}

	@Override
	default void updateRow() throws SQLException {
		getWrapped().updateRow();
	}

	@Override
	default void deleteRow() throws SQLException {
		getWrapped().deleteRow();
	}

	@Override
	default void refreshRow() throws SQLException {
		getWrapped().refreshRow();
	}

	@Override
	default void cancelRowUpdates() throws SQLException {
		getWrapped().cancelRowUpdates();
	}

	@Override
	default void moveToInsertRow() throws SQLException {
		getWrapped().moveToInsertRow();
	}

	@Override
	default void moveToCurrentRow() throws SQLException {
		getWrapped().moveToCurrentRow();
	}

	@Override
	StatementWrapper getStatement() throws SQLException;

	@Override
	default Object getObject(int columnIndex, Map<String, Class<?>> map) throws SQLException {
		// TODO: How can we wrap SQLData on UDT maps?
		return getWrapped().getObject(columnIndex, map);
	}

	@Override
	RefWrapper getRef(int columnIndex) throws SQLException;

	@Override
	BlobWrapper getBlob(int columnIndex) throws SQLException;

	@Override
	ClobWrapper getClob(int columnIndex) throws SQLException;

	@Override
	ArrayWrapper getArray(int columnIndex) throws SQLException;

	@Override
	default Object getObject(String columnLabel, Map<String, Class<?>> map) throws SQLException {
		// TODO: How can we wrap SQLData on UDT maps?
		return getWrapped().getObject(columnLabel, map);
	}

	@Override
	RefWrapper getRef(String columnLabel) throws SQLException;

	@Override
	BlobWrapper getBlob(String columnLabel) throws SQLException;

	@Override
	ClobWrapper getClob(String columnLabel) throws SQLException;

	@Override
	ArrayWrapper getArray(String columnLabel) throws SQLException;

	@Override
	default Date getDate(int columnIndex, Calendar cal) throws SQLException {
		return getWrapped().getDate(columnIndex, cal);
	}

	@Override
	default Date getDate(String columnLabel, Calendar cal) throws SQLException {
		return getWrapped().getDate(columnLabel, cal);
	}

	@Override
	default Time getTime(int columnIndex, Calendar cal) throws SQLException {
		return getWrapped().getTime(columnIndex, cal);
	}

	@Override
	default Time getTime(String columnLabel, Calendar cal) throws SQLException {
		return getWrapped().getTime(columnLabel, cal);
	}

	@Override
	default Timestamp getTimestamp(int columnIndex, Calendar cal) throws SQLException {
		return getWrapped().getTimestamp(columnIndex, cal);
	}

	@Override
	default Timestamp getTimestamp(String columnLabel, Calendar cal) throws SQLException {
		return getWrapped().getTimestamp(columnLabel, cal);
	}

	@Override
	default URL getURL(int columnIndex) throws SQLException {
		return getWrapped().getURL(columnIndex);
	}

	@Override
	default URL getURL(String columnLabel) throws SQLException {
		return getWrapped().getURL(columnLabel);
	}

	@Override
	void updateRef(int columnIndex, Ref x) throws SQLException;

	@Override
	void updateRef(String columnLabel, Ref x) throws SQLException;

	@Override
	void updateBlob(int columnIndex, Blob x) throws SQLException;

	@Override
	void updateBlob(String columnLabel, Blob x) throws SQLException;

	@Override
	void updateClob(int columnIndex, Clob x) throws SQLException;

	@Override
	void updateClob(String columnLabel, Clob x) throws SQLException;

	@Override
	void updateArray(int columnIndex, Array x) throws SQLException;

	@Override
	void updateArray(String columnLabel, Array x) throws SQLException;

	@Override
	RowIdWrapper getRowId(int columnIndex) throws SQLException;

	@Override
	RowIdWrapper getRowId(String columnLabel) throws SQLException;

	@Override
	void updateRowId(int columnIndex, RowId x) throws SQLException;

	@Override
	void updateRowId(String columnLabel, RowId x) throws SQLException;

	@Override
	default int getHoldability() throws SQLException {
		return getWrapped().getHoldability();
	}

	@Override
	default boolean isClosed() throws SQLException {
		return getWrapped().isClosed();
	}

	@Override
	default void updateNString(int columnIndex, String nString) throws SQLException {
		getWrapped().updateNString(columnIndex, nString);
	}

	@Override
	default void updateNString(String columnLabel, String nString) throws SQLException {
		getWrapped().updateNString(columnLabel, nString);
	}

	@Override
	void updateNClob(int columnIndex, NClob nClob) throws SQLException;

	@Override
	void updateNClob(String columnLabel, NClob nClob) throws SQLException;

	@Override
	NClobWrapper getNClob(int columnIndex) throws SQLException;

	@Override
	NClobWrapper getNClob(String columnLabel) throws SQLException;

	@Override
	SQLXMLWrapper getSQLXML(int columnIndex) throws SQLException;

	@Override
	SQLXMLWrapper getSQLXML(String columnLabel) throws SQLException;

	@Override
	void updateSQLXML(int columnIndex, SQLXML xmlObject) throws SQLException;

	@Override
	void updateSQLXML(String columnLabel, SQLXML xmlObject) throws SQLException;

	@Override
	default String getNString(int columnIndex) throws SQLException {
		return getWrapped().getNString(columnIndex);
	}

	@Override
	default String getNString(String columnLabel) throws SQLException {
		return getWrapped().getNString(columnLabel);
	}

	@Override
	ReaderWrapper getNCharacterStream(int columnIndex) throws SQLException;

	@Override
	ReaderWrapper getNCharacterStream(String columnLabel) throws SQLException;

	@Override
	void updateNCharacterStream(int columnIndex, Reader x, long length) throws SQLException;

	@Override
	void updateNCharacterStream(String columnLabel, Reader reader, long length) throws SQLException;

	@Override
	void updateAsciiStream(int columnIndex, InputStream x, long length) throws SQLException;

	@Override
	void updateBinaryStream(int columnIndex, InputStream x, long length) throws SQLException;

	@Override
	void updateCharacterStream(int columnIndex, Reader x, long length) throws SQLException;

	@Override
	void updateAsciiStream(String columnLabel, InputStream x, long length) throws SQLException;

	@Override
	void updateBinaryStream(String columnLabel, InputStream x, long length) throws SQLException;

	@Override
	void updateCharacterStream(String columnLabel, Reader reader, long length) throws SQLException;

	@Override
	void updateBlob(int columnIndex, InputStream inputStream, long length) throws SQLException;

	@Override
	void updateBlob(String columnLabel, InputStream inputStream, long length) throws SQLException;

	@Override
	void updateClob(int columnIndex, Reader reader, long length) throws SQLException;

	@Override
	void updateClob(String columnLabel, Reader reader, long length) throws SQLException;

	@Override
	void updateNClob(int columnIndex, Reader reader, long length) throws SQLException;

	@Override
	void updateNClob(String columnLabel, Reader reader, long length) throws SQLException;

	@Override
	void updateNCharacterStream(int columnIndex, Reader x) throws SQLException;

	@Override
	void updateNCharacterStream(String columnLabel, Reader reader) throws SQLException;

	@Override
	void updateAsciiStream(int columnIndex, InputStream x) throws SQLException;

	@Override
	void updateBinaryStream(int columnIndex, InputStream x) throws SQLException;

	@Override
	void updateCharacterStream(int columnIndex, Reader x) throws SQLException;

	@Override
	void updateAsciiStream(String columnLabel, InputStream x) throws SQLException;

	@Override
	void updateBinaryStream(String columnLabel, InputStream x) throws SQLException;

	@Override
	void updateCharacterStream(String columnLabel, Reader reader) throws SQLException;

	@Override
	void updateBlob(int columnIndex, InputStream inputStream) throws SQLException;

	@Override
	void updateBlob(String columnLabel, InputStream inputStream) throws SQLException;

	@Override
	void updateClob(int columnIndex, Reader reader) throws SQLException;

	@Override
	void updateClob(String columnLabel, Reader reader) throws SQLException;

	@Override
	void updateNClob(int columnIndex, Reader reader) throws SQLException;

	@Override
	void updateNClob(String columnLabel, Reader reader) throws SQLException;

	@Override
	default <T> T getObject(int columnIndex, Class<T> type) throws SQLException {
		return getWrapped().getObject(columnIndex, type);
	}

	@Override
	default <T> T getObject(String columnLabel, Class<T> type) throws SQLException {
		return getWrapped().getObject(columnLabel, type);
	}

	@Override
	default void updateObject(int columnIndex, Object x, SQLType targetSqlType, int scaleOrLength)  throws SQLException {
		getWrapped().updateObject(columnIndex, x, targetSqlType, scaleOrLength);
	}

	@Override
	default void updateObject(String columnLabel, Object x, SQLType targetSqlType, int scaleOrLength) throws SQLException {
		getWrapped().updateObject(columnLabel, x, targetSqlType, scaleOrLength);
	}

	@Override
	default void updateObject(int columnIndex, Object x, SQLType targetSqlType) throws SQLException {
		getWrapped().updateObject(columnIndex, x, targetSqlType);
	}

	@Override
	default void updateObject(String columnLabel, Object x, SQLType targetSqlType) throws SQLException {
		getWrapped().updateObject(columnLabel, x, targetSqlType);
	}
}
