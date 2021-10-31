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

import java.io.InputStream;
import java.io.Reader;
import java.sql.Array;
import java.sql.Blob;
import java.sql.Clob;
import java.sql.NClob;
import java.sql.ParameterMetaData;
import java.sql.PreparedStatement;
import java.sql.Ref;
import java.sql.ResultSetMetaData;
import java.sql.RowId;
import java.sql.SQLException;
import java.sql.SQLXML;

/**
 * Wraps a {@link PreparedStatement}.
 *
 * @author  AO Industries, Inc.
 */
public class PreparedStatementWrapperImpl extends StatementWrapperImpl implements PreparedStatementWrapper {

	public PreparedStatementWrapperImpl(ConnectionWrapperImpl connectionWrapper, PreparedStatement wrapped) {
		super(connectionWrapper, wrapped);
	}

	@Override
	public PreparedStatement getWrapped() {
		return (PreparedStatement)super.getWrapped();
	}

	/**
	 * Unwraps an {@link Array}, if wrapped by this wrapper.
	 *
	 * @see  ConnectionWrapperImpl#unwrapArray(java.sql.Array)
	 */
	protected Array unwrapArray(Array array) {
		return getConnectionWrapper().unwrapArray(array);
	}

	/**
	 * Unwraps a {@link Blob}, if wrapped by this wrapper.
	 *
	 * @see  ConnectionWrapperImpl#unwrapBlob(java.sql.Blob)
	 */
	protected Blob unwrapBlob(Blob blob) {
		return getConnectionWrapper().unwrapBlob(blob);
	}

	/**
	 * Unwraps a {@link Clob}, if wrapped by this wrapper.
	 *
	 * @see  ConnectionWrapperImpl#unwrapClob(java.sql.Clob)
	 */
	protected Clob unwrapClob(Clob clob) {
		return getConnectionWrapper().unwrapClob(clob);
	}

	/**
	 * Unwraps an {@link InputStream}, if wrapped by this wrapper.
	 *
	 * @see  ConnectionWrapperImpl#unwrapInputStream(java.io.InputStream)
	 */
	protected InputStream unwrapInputStream(InputStream in) {
		return getConnectionWrapper().unwrapInputStream(in);
	}

	/**
	 * Unwraps a {@link NClob}, if wrapped by this wrapper.
	 *
	 * @see  ConnectionWrapperImpl#unwrapNClob(java.sql.NClob)
	 */
	protected NClob unwrapNClob(NClob nclob) {
		return getConnectionWrapper().unwrapNClob(nclob);
	}

	/**
	 * Wraps a {@link ParameterMetaData}, if not already wrapped by this wrapper.
	 *
	 * @see  ConnectionWrapperImpl#wrapParameterMetaData(java.sql.ParameterMetaData)
	 */
	protected ParameterMetaDataWrapperImpl wrapParameterMetaData(ParameterMetaData metaData) {
		return getConnectionWrapper().wrapParameterMetaData(metaData);
	}

	/**
	 * Unwraps a {@link Reader}, if wrapped by this wrapper.
	 *
	 * @see  ConnectionWrapperImpl#unwrapReader(java.io.Reader)
	 */
	protected Reader unwrapReader(Reader in) {
		return getConnectionWrapper().unwrapReader(in);
	}

	/**
	 * Unwraps a {@link Ref}, if wrapped by this wrapper.
	 *
	 * @see  ConnectionWrapperImpl#unwrapRef(java.sql.Ref)
	 */
	protected Ref unwrapRef(Ref ref) {
		return getConnectionWrapper().unwrapRef(ref);
	}

	/**
	 * Wraps a {@link ResultSetMetaData}, if not already wrapped by this wrapper.
	 *
	 * @see  ConnectionWrapperImpl#wrapResultSetMetaData(java.sql.ResultSetMetaData)
	 */
	protected ResultSetMetaDataWrapperImpl wrapResultSetMetaData(ResultSetMetaData metaData) {
		return getConnectionWrapper().wrapResultSetMetaData(metaData);
	}

	/**
	 * Unwraps a {@link RowId}, if wrapped by this wrapper.
	 *
	 * @see  ConnectionWrapperImpl#unwrapRowId(java.sql.RowId)
	 */
	protected RowId unwrapRowId(RowId rowId) {
		return getConnectionWrapper().unwrapRowId(rowId);
	}

	/**
	 * Unwraps a {@link SQLXML}, if wrapped by this wrapper.
	 *
	 * @see  ConnectionWrapperImpl#unwrapSQLXML(java.sql.SQLXML)
	 */
	protected SQLXML unwrapSQLXML(SQLXML sqlXml) {
		return getConnectionWrapper().unwrapSQLXML(sqlXml);
	}

	/**
	 * @see  #wrapResultSet(java.sql.ResultSet)
	 */
	@Override
	public ResultSetWrapperImpl executeQuery() throws SQLException {
		return wrapResultSet(getWrapped().executeQuery());
	}

	/**
	 * @see  #unwrapInputStream(java.io.InputStream)
	 */
	@Override
	public void setAsciiStream(int parameterIndex, InputStream x, int length) throws SQLException {
		getWrapped().setAsciiStream(parameterIndex, unwrapInputStream(x), length);
	}

	/**
	 * @see  #unwrapInputStream(java.io.InputStream)
	 */
	@Override
	@Deprecated // Java 9: (since="1.2")
	public void setUnicodeStream(int parameterIndex, InputStream x, int length) throws SQLException {
		getWrapped().setUnicodeStream(parameterIndex, unwrapInputStream(x), length);
	}

	/**
	 * @see  #unwrapInputStream(java.io.InputStream)
	 */
	@Override
	public void setBinaryStream(int parameterIndex, InputStream x, int length) throws SQLException {
		getWrapped().setBinaryStream(parameterIndex, unwrapInputStream(x), length);
	}

	/**
	 * @see  #unwrapReader(java.io.Reader)
	 */
	@Override
	public void setCharacterStream(int parameterIndex, Reader reader, int length) throws SQLException {
		getWrapped().setCharacterStream(parameterIndex, unwrapReader(reader), length);
	}

	/**
	 * @see  #unwrapRef(java.sql.Ref)
	 */
	@Override
	public void setRef(int parameterIndex, Ref x) throws SQLException {
		getWrapped().setRef(parameterIndex, unwrapRef(x));
	}

	/**
	 * @see  #unwrapBlob(java.sql.Blob)
	 */
	@Override
	public void setBlob(int parameterIndex, Blob x) throws SQLException {
		getWrapped().setBlob(parameterIndex, unwrapBlob(x));
	}

	/**
	 * @see  #unwrapClob(java.sql.Clob)
	 */
	@Override
	public void setClob(int parameterIndex, Clob x) throws SQLException {
		getWrapped().setClob(parameterIndex, unwrapClob(x));
	}

	/**
	 * @see  #unwrapArray(java.sql.Array)
	 */
	@Override
	public void setArray(int parameterIndex, Array x) throws SQLException {
		getWrapped().setArray(parameterIndex, unwrapArray(x));
	}

	/**
	 * @see  #wrapResultSetMetaData(java.sql.ResultSetMetaData)
	 */
	@Override
	public ResultSetMetaDataWrapperImpl getMetaData() throws SQLException {
		return wrapResultSetMetaData(getWrapped().getMetaData());
	}

	/**
	 * @see  #wrapParameterMetaData(java.sql.ParameterMetaData)
	 */
	@Override
	public ParameterMetaDataWrapperImpl getParameterMetaData() throws SQLException {
		return wrapParameterMetaData(getWrapped().getParameterMetaData());
	}

	/**
	 * @see  #unwrapRowId(java.sql.RowId)
	 */
	@Override
	public void setRowId(int parameterIndex, RowId x) throws SQLException {
		getWrapped().setRowId(parameterIndex, unwrapRowId(x));
	}

	/**
	 * @see  #unwrapReader(java.io.Reader)
	 */
	@Override
	public void setNCharacterStream(int parameterIndex, Reader value, long length) throws SQLException {
		getWrapped().setNCharacterStream(parameterIndex, unwrapReader(value), length);
	}

	/**
	 * @see  #unwrapNClob(java.sql.NClob)
	 */
	@Override
	public void setNClob(int parameterIndex, NClob value) throws SQLException {
		getWrapped().setNClob(parameterIndex, unwrapNClob(value));
	}

	/**
	 * @see  #unwrapReader(java.io.Reader)
	 */
	@Override
	public void setClob(int parameterIndex, Reader reader, long length) throws SQLException {
		getWrapped().setClob(parameterIndex, unwrapReader(reader), length);
	}

	/**
	 * @see  #unwrapInputStream(java.io.InputStream)
	 */
	@Override
	public void setBlob(int parameterIndex, InputStream inputStream, long length) throws SQLException {
		getWrapped().setBlob(parameterIndex, unwrapInputStream(inputStream), length);
	}

	/**
	 * @see  #unwrapReader(java.io.Reader)
	 */
	@Override
	public void setNClob(int parameterIndex, Reader reader, long length) throws SQLException {
		getWrapped().setNClob(parameterIndex, unwrapReader(reader), length);
	}

	/**
	 * @see  #unwrapSQLXML(java.sql.SQLXML)
	 */
	@Override
	public void setSQLXML(int parameterIndex, SQLXML xmlObject) throws SQLException {
		getWrapped().setSQLXML(parameterIndex, unwrapSQLXML(xmlObject));
	}

	/**
	 * @see  #unwrapInputStream(java.io.InputStream)
	 */
	@Override
	public void setAsciiStream(int parameterIndex, InputStream x, long length) throws SQLException {
		getWrapped().setAsciiStream(parameterIndex, unwrapInputStream(x), length);
	}

	/**
	 * @see  #unwrapInputStream(java.io.InputStream)
	 */
	@Override
	public void setBinaryStream(int parameterIndex, InputStream x, long length) throws SQLException {
		getWrapped().setBinaryStream(parameterIndex, unwrapInputStream(x), length);
	}

	/**
	 * @see  #unwrapReader(java.io.Reader)
	 */
	@Override
	public void setCharacterStream(int parameterIndex, Reader reader, long length) throws SQLException {
		getWrapped().setCharacterStream(parameterIndex, unwrapReader(reader), length);
	}

	/**
	 * @see  #unwrapInputStream(java.io.InputStream)
	 */
	@Override
	public void setAsciiStream(int parameterIndex, InputStream x) throws SQLException {
		getWrapped().setAsciiStream(parameterIndex, unwrapInputStream(x));
	}

	/**
	 * @see  #unwrapInputStream(java.io.InputStream)
	 */
	@Override
	public void setBinaryStream(int parameterIndex, InputStream x) throws SQLException {
		getWrapped().setBinaryStream(parameterIndex, unwrapInputStream(x));
	}

	/**
	 * @see  #unwrapReader(java.io.Reader)
	 */
	@Override
	public void setCharacterStream(int parameterIndex, Reader reader) throws SQLException {
		getWrapped().setCharacterStream(parameterIndex, unwrapReader(reader));
	}

	/**
	 * @see  #unwrapReader(java.io.Reader)
	 */
	@Override
	public void setNCharacterStream(int parameterIndex, Reader value) throws SQLException {
		getWrapped().setNCharacterStream(parameterIndex, unwrapReader(value));
	}

	/**
	 * @see  #unwrapReader(java.io.Reader)
	 */
	@Override
	public void setClob(int parameterIndex, Reader reader) throws SQLException {
		getWrapped().setClob(parameterIndex, unwrapReader(reader));
	}

	/**
	 * @see  #unwrapInputStream(java.io.InputStream)
	 */
	@Override
	public void setBlob(int parameterIndex, InputStream inputStream) throws SQLException {
		getWrapped().setBlob(parameterIndex, unwrapInputStream(inputStream));
	}

	/**
	 * @see  #unwrapReader(java.io.Reader)
	 */
	@Override
	public void setNClob(int parameterIndex, Reader reader) throws SQLException {
		getWrapped().setNClob(parameterIndex, unwrapReader(reader));
	}
}
