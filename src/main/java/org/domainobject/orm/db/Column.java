package org.domainobject.orm.db;

import java.sql.SQLType;

/**
 * A Column object describes the columns in an {@link Entity}.
 */
public interface Column {

	/**
	 * Returns the entity to which the column belongs.
	 * 
	 * @return The entity
	 */
	Entity getEntity();

	/**
	 * Returns the name of the column.
	 * 
	 * @return The name of the column
	 */
	String getName();

	/**
	 * Returns the datatype of the column. This will be one of the constants of
	 * {@link SQLType}.
	 * 
	 * @return The datatype of the column
	 */
	int getDataType();

	/**
	 * Returns the maximum width of the column.
	 * 
	 * @return The maximum width of the column
	 */
	int getColumnSize();

	/**
	 * Returns the ordinal position of the column within the table, view or
	 * entity.
	 * 
	 * @return The rdinal position of the column within the table, view or
	 *         entity
	 */
	int getOrdinalPosition();

	/**
	 * Returns whether or not the column is NOT NULL.
	 * 
	 * @return Whether or not the column is NOT NULL
	 */
	boolean isNullable();

	boolean isAutoIncrement();

}