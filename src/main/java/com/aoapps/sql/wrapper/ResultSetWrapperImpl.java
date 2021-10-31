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
import java.sql.Ref;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.RowId;
import java.sql.SQLException;
import java.sql.SQLXML;
import java.sql.Statement;
import java.util.Optional;

/**
 * Wraps a {@link ResultSet}.
 *
 * @author  AO Industries, Inc.
 */
public class ResultSetWrapperImpl implements ResultSetWrapper {

	private final ConnectionWrapperImpl connectionWrapper;
	private final StatementWrapperImpl stmtWrapper;
	private final ResultSet wrapped;

	public ResultSetWrapperImpl(ConnectionWrapperImpl connectionWrapper, StatementWrapperImpl stmtWrapper, ResultSet wrapped) {
		this.connectionWrapper = connectionWrapper;
		this.stmtWrapper = stmtWrapper;
		this.wrapped = wrapped;
	}

	/**
	 * Gets the connection wrapper.
	 */
	protected ConnectionWrapperImpl getConnectionWrapper() {
		return connectionWrapper;
	}

	/**
	 * Gets the statement wrapper.
	 */
	protected Optional<? extends StatementWrapperImpl> getStatementWrapper() {
		return Optional.ofNullable(stmtWrapper);
	}

	@Override
	public ResultSet getWrapped() {
		return wrapped;
	}

	@Override
	public String toString() {
		return getWrapped().toString();
	}

	/**
	 * Wraps an {@link Array}, if not already wrapped by this wrapper.
	 *
	 * @see  ConnectionWrapperImpl#wrapArray(com.aoapps.sql.wrapper.StatementWrapperImpl, java.sql.Array)
	 */
	protected ArrayWrapperImpl wrapArray(Array array) {
		return getConnectionWrapper().wrapArray(getStatementWrapper().orElse(null), array);
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
	 * Wraps a {@link Blob}, if not already wrapped by this wrapper.
	 *
	 * @see  ConnectionWrapperImpl#wrapBlob(java.sql.Blob)
	 */
	protected BlobWrapperImpl wrapBlob(Blob blob) {
		return getConnectionWrapper().wrapBlob(blob);
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
	 * Wraps a {@link Clob}, if not already wrapped by this wrapper.
	 *
	 * @see  ConnectionWrapperImpl#wrapClob(java.sql.Clob)
	 */
	protected ClobWrapperImpl wrapClob(Clob clob) {
		return getConnectionWrapper().wrapClob(clob);
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
	 * Wraps an {@link InputStream}, if not already wrapped by this wrapper.
	 *
	 * @see  ConnectionWrapperImpl#wrapInputStream(java.io.InputStream)
	 */
	protected InputStreamWrapper wrapInputStream(InputStream in) {
		return getConnectionWrapper().wrapInputStream(in);
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
	 * Wraps a {@link NClob}, if not already wrapped by this wrapper.
	 *
	 * @see  ConnectionWrapperImpl#wrapNClob(java.sql.NClob)
	 */
	protected NClobWrapperImpl wrapNClob(NClob nclob) {
		return getConnectionWrapper().wrapNClob(nclob);
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
	 * Wraps a {@link Reader}, if not already wrapped by this wrapper.
	 *
	 * @see  ConnectionWrapperImpl#wrapReader(java.sql.Reader)
	 */
	protected ReaderWrapper wrapReader(Reader in) {
		return getConnectionWrapper().wrapReader(in);
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
	 * Wraps a {@link Ref}, if not already wrapped by this wrapper.
	 *
	 * @see  ConnectionWrapperImpl#wrapRef(java.sql.Ref)
	 */
	protected RefWrapperImpl wrapRef(Ref ref) {
		return getConnectionWrapper().wrapRef(ref);
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
	 * Wraps a {@link RowId}, if not already wrapped by this wrapper.
	 *
	 * @see  ConnectionWrapperImpl#wrapRowId(RowId)
	 */
	protected RowIdWrapperImpl wrapRowId(RowId rowId) {
		return getConnectionWrapper().wrapRowId(rowId);
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
	 * Wraps a {@link SQLXML}, if not already wrapped by this wrapper.
	 *
	 * @see  ConnectionWrapperImpl#wrapSQLXML(java.sql.SQLXML)
	 */
	protected SQLXMLWrapperImpl wrapSQLXML(SQLXML sqlXml) {
		return getConnectionWrapper().wrapSQLXML(sqlXml);
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
	 * Wraps a {@link Statement}, if not already wrapped by this wrapper.
	 *
	 * @see  ConnectionWrapperImpl#wrapStatement(java.sql.Statement)
	 */
	protected StatementWrapperImpl wrapStatement(Statement stmt) {
		// First check if matches our statement wrapper
		if(
			stmtWrapper == stmt
			|| (
				stmtWrapper != null
				&& stmtWrapper.getWrapped() == stmt
			)
		) {
			return stmtWrapper;
		} else {
			// Wrap now, if needed
			return getConnectionWrapper().wrapStatement(stmt);
		}
	}

	/**
	 * @see  #wrapInputStream(java.io.InputStream)
	 */
	@Override
	public InputStreamWrapper getAsciiStream(int columnIndex) throws SQLException {
		return wrapInputStream(getWrapped().getAsciiStream(columnIndex));
	}

	/**
	 * @see  #wrapInputStream(java.io.InputStream)
	 */
	@Override
	@Deprecated // Java 9: (since="1.2")
	public InputStreamWrapper getUnicodeStream(int columnIndex) throws SQLException {
		return wrapInputStream(getWrapped().getUnicodeStream(columnIndex));
	}

	/**
	 * @see  #wrapInputStream(java.io.InputStream)
	 */
	@Override
	public InputStreamWrapper getBinaryStream(int columnIndex) throws SQLException {
		return wrapInputStream(getWrapped().getBinaryStream(columnIndex));
	}

	/**
	 * @see  #wrapInputStream(java.io.InputStream)
	 */
	@Override
	public InputStreamWrapper getAsciiStream(String columnLabel) throws SQLException {
		return wrapInputStream(getWrapped().getAsciiStream(columnLabel));
	}

	/**
	 * @see  #wrapInputStream(java.io.InputStream)
	 */
	@Override
	@Deprecated // Java 9: (since="1.2")
	public InputStreamWrapper getUnicodeStream(String columnLabel) throws SQLException {
		return wrapInputStream(getWrapped().getUnicodeStream(columnLabel));
	}

	/**
	 * @see  #wrapInputStream(java.io.InputStream)
	 */
	@Override
	public InputStreamWrapper getBinaryStream(String columnLabel) throws SQLException {
		return wrapInputStream(getWrapped().getBinaryStream(columnLabel));
	}

	/**
	 * @see  #wrapResultSetMetaData(java.sql.ResultSetMetaData)
	 */
	@Override
	public ResultSetMetaDataWrapperImpl getMetaData() throws SQLException {
		return wrapResultSetMetaData(getWrapped().getMetaData());
	}

	/**
	 * @see  #wrapReader(java.io.Reader)
	 */
	@Override
	public ReaderWrapper getCharacterStream(int columnIndex) throws SQLException {
		return wrapReader(getWrapped().getCharacterStream(columnIndex));
	}

	/**
	 * @see  #wrapReader(java.io.Reader)
	 */
	@Override
	public ReaderWrapper getCharacterStream(String columnLabel) throws SQLException {
		return wrapReader(getWrapped().getCharacterStream(columnLabel));
	}

	/**
	 * @see  #unwrapInputStream(java.io.InputStream)
	 */
	@Override
	public void updateAsciiStream(int columnIndex, InputStream x, int length) throws SQLException {
		getWrapped().updateAsciiStream(columnIndex, unwrapInputStream(x), length);
	}

	/**
	 * @see  #unwrapInputStream(java.io.InputStream)
	 */
	@Override
	public void updateBinaryStream(int columnIndex, InputStream x, int length) throws SQLException {
		getWrapped().updateBinaryStream(columnIndex, unwrapInputStream(x), length);
	}

	/**
	 * @see  #unwrapReader(java.io.Reader)
	 */
	@Override
	public void updateCharacterStream(int columnIndex, Reader x, int length) throws SQLException {
		getWrapped().updateCharacterStream(columnIndex, unwrapReader(x), length);
	}

	/**
	 * @see  #unwrapInputStream(java.io.InputStream)
	 */
	@Override
	public void updateAsciiStream(String columnLabel, InputStream x, int length) throws SQLException {
		getWrapped().updateAsciiStream(columnLabel, unwrapInputStream(x), length);
	}

	/**
	 * @see  #unwrapInputStream(java.io.InputStream)
	 */
	@Override
	public void updateBinaryStream(String columnLabel, InputStream x, int length) throws SQLException {
		getWrapped().updateBinaryStream(columnLabel, unwrapInputStream(x), length);
	}

	/**
	 * @see  #unwrapReader(java.io.Reader)
	 */
	@Override
	public void updateCharacterStream(String columnLabel, Reader reader, int length) throws SQLException {
		getWrapped().updateCharacterStream(columnLabel, unwrapReader(reader), length);
	}

	/**
	 * @see  #wrapStatement(java.sql.Statement)
	 */
	@Override
	public StatementWrapperImpl getStatement() throws SQLException {
		return wrapStatement(getWrapped().getStatement());
	}

	/**
	 * @see  #wrapRef(java.sql.Ref)
	 */
	@Override
	public RefWrapperImpl getRef(int columnIndex) throws SQLException {
		return wrapRef(getWrapped().getRef(columnIndex));
	}

	/**
	 * @see  #wrapBlob(java.sql.Blob)
	 */
	@Override
	public BlobWrapperImpl getBlob(int columnIndex) throws SQLException {
		return wrapBlob(getWrapped().getBlob(columnIndex));
	}

	/**
	 * @see  #wrapClob(java.sql.Clob)
	 */
	@Override
	public ClobWrapperImpl getClob(int columnIndex) throws SQLException {
		return wrapClob(getWrapped().getClob(columnIndex));
	}

	/**
	 * @see  #wrapArray(java.sql.Array)
	 */
	@Override
	public ArrayWrapperImpl getArray(int columnIndex) throws SQLException {
		return wrapArray(getWrapped().getArray(columnIndex));
	}

	/**
	 * @see  #wrapRef(java.sql.Ref)
	 */
	@Override
	public RefWrapperImpl getRef(String columnLabel) throws SQLException {
		return wrapRef(getWrapped().getRef(columnLabel));
	}

	/**
	 * @see  #wrapBlob(java.sql.Blob)
	 */
	@Override
	public BlobWrapperImpl getBlob(String columnLabel) throws SQLException {
		return wrapBlob(getWrapped().getBlob(columnLabel));
	}

	/**
	 * @see  #wrapClob(java.sql.Clob)
	 */
	@Override
	public ClobWrapperImpl getClob(String columnLabel) throws SQLException {
		return wrapClob(getWrapped().getClob(columnLabel));
	}

	/**
	 * @see  #wrapArray(java.sql.Array)
	 */
	@Override
	public ArrayWrapperImpl getArray(String columnLabel) throws SQLException {
		return wrapArray(getWrapped().getArray(columnLabel));
	}

	/**
	 * @see  #unwrapRef(java.sql.Ref)
	 */
	@Override
	public void updateRef(int columnIndex, Ref x) throws SQLException {
		getWrapped().updateRef(columnIndex, unwrapRef(x));
	}

	/**
	 * @see  #unwrapRef(java.sql.Ref)
	 */
	@Override
	public void updateRef(String columnLabel, Ref x) throws SQLException {
		getWrapped().updateRef(columnLabel, unwrapRef(x));
	}

	/**
	 * @see  #unwrapBlob(java.sql.Blob)
	 */
	@Override
	public void updateBlob(int columnIndex, Blob x) throws SQLException {
		getWrapped().updateBlob(columnIndex, unwrapBlob(x));
	}

	/**
	 * @see  #unwrapBlob(java.sql.Blob)
	 */
	@Override
	public void updateBlob(String columnLabel, Blob x) throws SQLException {
		getWrapped().updateBlob(columnLabel, unwrapBlob(x));
	}

	/**
	 * @see  #unwrapClob(java.sql.Clob)
	 */
	@Override
	public void updateClob(int columnIndex, Clob x) throws SQLException {
		getWrapped().updateClob(columnIndex, unwrapClob(x));
	}

	/**
	 * @see  #unwrapClob(java.sql.Clob)
	 */
	@Override
	public void updateClob(String columnLabel, Clob x) throws SQLException {
		getWrapped().updateClob(columnLabel, unwrapClob(x));
	}

	/**
	 * @see  #unwrapArray(java.sql.Array)
	 */
	@Override
	public void updateArray(int columnIndex, Array x) throws SQLException {
		getWrapped().updateArray(columnIndex, unwrapArray(x));
	}

	/**
	 * @see  #unwrapArray(java.sql.Array)
	 */
	@Override
	public void updateArray(String columnLabel, Array x) throws SQLException {
		getWrapped().updateArray(columnLabel, unwrapArray(x));
	}

	/**
	 * @see  #wrapRowId(java.sql.RowId)
	 */
	@Override
	public RowIdWrapperImpl getRowId(int columnIndex) throws SQLException {
		return wrapRowId(getWrapped().getRowId(columnIndex));
	}

	/**
	 * @see  #wrapRowId(java.sql.RowId)
	 */
	@Override
	public RowIdWrapperImpl getRowId(String columnLabel) throws SQLException {
		return wrapRowId(getWrapped().getRowId(columnLabel));
	}

	/**
	 * @see  #unwrapRowId(java.sql.RowId)
	 */
	@Override
	public void updateRowId(int columnIndex, RowId x) throws SQLException {
		getWrapped().updateRowId(columnIndex, unwrapRowId(x));
	}

	/**
	 * @see  #unwrapRowId(java.sql.RowId)
	 */
	@Override
	public void updateRowId(String columnLabel, RowId x) throws SQLException {
		getWrapped().updateRowId(columnLabel, unwrapRowId(x));
	}

	/**
	 * @see  #unwrapNClob(java.sql.NClob) 
	 */
	@Override
	public void updateNClob(int columnIndex, NClob nClob) throws SQLException {
		getWrapped().updateNClob(columnIndex, unwrapNClob(nClob));
	}

	/**
	 * @see  #unwrapNClob(java.sql.NClob) 
	 */
	@Override
	public void updateNClob(String columnLabel, NClob nClob) throws SQLException {
		getWrapped().updateNClob(columnLabel, unwrapNClob(nClob));
	}

	/**
	 * @see  #wrapNClob(java.sql.NClob) 
	 */
	@Override
	public NClobWrapperImpl getNClob(int columnIndex) throws SQLException {
		return wrapNClob(getWrapped().getNClob(columnIndex));
	}

	/**
	 * @see  #wrapNClob(java.sql.NClob) 
	 */
	@Override
	public NClobWrapperImpl getNClob(String columnLabel) throws SQLException {
		return wrapNClob(getWrapped().getNClob(columnLabel));
	}

	/**
	 * @see  #wrapSQLXML(java.sql.SQLXML) 
	 */
	@Override
	public SQLXMLWrapperImpl getSQLXML(int columnIndex) throws SQLException {
		return wrapSQLXML(getWrapped().getSQLXML(columnIndex));
	}

	/**
	 * @see  #wrapSQLXML(java.sql.SQLXML) 
	 */
	@Override
	public SQLXMLWrapperImpl getSQLXML(String columnLabel) throws SQLException {
		return wrapSQLXML(getWrapped().getSQLXML(columnLabel));
	}

	/**
	 * @see  #unwrapSQLXML(java.sql.SQLXML) 
	 */
	@Override
	public void updateSQLXML(int columnIndex, SQLXML xmlObject) throws SQLException {
		getWrapped().updateSQLXML(columnIndex, unwrapSQLXML(xmlObject));
	}

	/**
	 * @see  #unwrapSQLXML(java.sql.SQLXML) 
	 */
	@Override
	public void updateSQLXML(String columnLabel, SQLXML xmlObject) throws SQLException {
		getWrapped().updateSQLXML(columnLabel, unwrapSQLXML(xmlObject));
	}

	/**
	 * @see  #wrapReader(java.io.Reader)
	 */
	@Override
	public ReaderWrapper getNCharacterStream(int columnIndex) throws SQLException {
		return wrapReader(getWrapped().getNCharacterStream(columnIndex));
	}

	/**
	 * @see  #wrapReader(java.io.Reader)
	 */
	@Override
	public ReaderWrapper getNCharacterStream(String columnLabel) throws SQLException {
		return wrapReader(getWrapped().getNCharacterStream(columnLabel));
	}

	/**
	 * @see  #unwrapReader(java.io.Reader)
	 */
	@Override
	public void updateNCharacterStream(int columnIndex, Reader x, long length) throws SQLException {
		getWrapped().updateNCharacterStream(columnIndex, unwrapReader(x), length);
	}

	/**
	 * @see  #unwrapReader(java.io.Reader)
	 */
	@Override
	public void updateNCharacterStream(String columnLabel, Reader reader, long length) throws SQLException {
		getWrapped().updateNCharacterStream(columnLabel, unwrapReader(reader), length);
	}

	/**
	 * @see  #unwrapInputStream(java.io.InputStream)
	 */
	@Override
	public void updateAsciiStream(int columnIndex, InputStream x, long length) throws SQLException {
		getWrapped().updateAsciiStream(columnIndex, unwrapInputStream(x), length);
	}

	/**
	 * @see  #unwrapInputStream(java.io.InputStream)
	 */
	@Override
	public void updateBinaryStream(int columnIndex, InputStream x, long length) throws SQLException {
		getWrapped().updateBinaryStream(columnIndex, unwrapInputStream(x), length);
	}

	/**
	 * @see  #unwrapReader(java.io.Reader)
	 */
	@Override
	public void updateCharacterStream(int columnIndex, Reader x, long length) throws SQLException {
		getWrapped().updateCharacterStream(columnIndex, unwrapReader(x), length);
	}

	/**
	 * @see  #unwrapInputStream(java.io.InputStream)
	 */
	@Override
	public void updateAsciiStream(String columnLabel, InputStream x, long length) throws SQLException {
		getWrapped().updateAsciiStream(columnLabel, unwrapInputStream(x), length);
	}

	/**
	 * @see  #unwrapInputStream(java.io.InputStream)
	 */
	@Override
	public void updateBinaryStream(String columnLabel, InputStream x, long length) throws SQLException {
		getWrapped().updateBinaryStream(columnLabel, unwrapInputStream(x), length);
	}

	/**
	 * @see  #unwrapReader(java.io.Reader)
	 */
	@Override
	public void updateCharacterStream(String columnLabel, Reader reader, long length) throws SQLException {
		getWrapped().updateCharacterStream(columnLabel, unwrapReader(reader), length);
	}

	/**
	 * @see  #unwrapInputStream(java.io.InputStream)
	 */
	@Override
	public void updateBlob(int columnIndex, InputStream inputStream, long length) throws SQLException {
		getWrapped().updateBlob(columnIndex, unwrapInputStream(inputStream), length);
	}

	/**
	 * @see  #unwrapInputStream(java.io.InputStream)
	 */
	@Override
	public void updateBlob(String columnLabel, InputStream inputStream, long length) throws SQLException {
		getWrapped().updateBlob(columnLabel, unwrapInputStream(inputStream), length);
	}

	/**
	 * @see  #unwrapReader(java.io.Reader)
	 */
	@Override
	public void updateClob(int columnIndex, Reader reader, long length) throws SQLException {
		getWrapped().updateClob(columnIndex, unwrapReader(reader), length);
	}

	/**
	 * @see  #unwrapReader(java.io.Reader)
	 */
	@Override
	public void updateClob(String columnLabel, Reader reader, long length) throws SQLException {
		getWrapped().updateClob(columnLabel, unwrapReader(reader), length);
	}

	/**
	 * @see  #unwrapReader(java.io.Reader)
	 */
	@Override
	public void updateNClob(int columnIndex, Reader reader, long length) throws SQLException {
		getWrapped().updateNClob(columnIndex, unwrapReader(reader), length);
	}

	/**
	 * @see  #unwrapReader(java.io.Reader)
	 */
	@Override
	public void updateNClob(String columnLabel, Reader reader, long length) throws SQLException {
		getWrapped().updateNClob(columnLabel, unwrapReader(reader), length);
	}

	/**
	 * @see  #unwrapReader(java.io.Reader)
	 */
	@Override
	public void updateNCharacterStream(int columnIndex, Reader x) throws SQLException {
		getWrapped().updateNCharacterStream(columnIndex, unwrapReader(x));
	}

	/**
	 * @see  #unwrapReader(java.io.Reader)
	 */
	@Override
	public void updateNCharacterStream(String columnLabel, Reader reader) throws SQLException {
		getWrapped().updateNCharacterStream(columnLabel, unwrapReader(reader));
	}

	/**
	 * @see  #unwrapInputStream(java.io.InputStream)
	 */
	@Override
	public void updateAsciiStream(int columnIndex, InputStream x) throws SQLException {
		getWrapped().updateAsciiStream(columnIndex, unwrapInputStream(x));
	}

	/**
	 * @see  #unwrapInputStream(java.io.InputStream)
	 */
	@Override
	public void updateBinaryStream(int columnIndex, InputStream x) throws SQLException {
		getWrapped().updateBinaryStream(columnIndex, unwrapInputStream(x));
	}

	/**
	 * @see  #unwrapReader(java.io.Reader)
	 */
	@Override
	public void updateCharacterStream(int columnIndex, Reader x) throws SQLException {
		getWrapped().updateCharacterStream(columnIndex, unwrapReader(x));
	}

	/**
	 * @see  #unwrapInputStream(java.io.InputStream)
	 */
	@Override
	public void updateAsciiStream(String columnLabel, InputStream x) throws SQLException {
		getWrapped().updateAsciiStream(columnLabel, unwrapInputStream(x));
	}

	/**
	 * @see  #unwrapInputStream(java.io.InputStream)
	 */
	@Override
	public void updateBinaryStream(String columnLabel, InputStream x) throws SQLException {
		getWrapped().updateBinaryStream(columnLabel, unwrapInputStream(x));
	}

	/**
	 * @see  #unwrapReader(java.io.Reader)
	 */
	@Override
	public void updateCharacterStream(String columnLabel, Reader reader) throws SQLException {
		getWrapped().updateCharacterStream(columnLabel, unwrapReader(reader));
	}

	/**
	 * @see  #unwrapInputStream(java.io.InputStream)
	 */
	@Override
	public void updateBlob(int columnIndex, InputStream inputStream) throws SQLException {
		getWrapped().updateBlob(columnIndex, unwrapInputStream(inputStream));
	}

	/**
	 * @see  #unwrapInputStream(java.io.InputStream)
	 */
	@Override
	public void updateBlob(String columnLabel, InputStream inputStream) throws SQLException {
		getWrapped().updateBlob(columnLabel, unwrapInputStream(inputStream));
	}

	/**
	 * @see  #unwrapReader(java.io.Reader)
	 */
	@Override
	public void updateClob(int columnIndex, Reader reader) throws SQLException {
		getWrapped().updateClob(columnIndex, unwrapReader(reader));
	}

	/**
	 * @see  #unwrapReader(java.io.Reader)
	 */
	@Override
	public void updateClob(String columnLabel, Reader reader) throws SQLException {
		getWrapped().updateClob(columnLabel, unwrapReader(reader));
	}

	/**
	 * @see  #unwrapReader(java.io.Reader)
	 */
	@Override
	public void updateNClob(int columnIndex, Reader reader) throws SQLException {
		getWrapped().updateNClob(columnIndex, unwrapReader(reader));
	}

	/**
	 * @see  #unwrapReader(java.io.Reader)
	 */
	@Override
	public void updateNClob(String columnLabel, Reader reader) throws SQLException {
		getWrapped().updateNClob(columnLabel, unwrapReader(reader));
	}
}
