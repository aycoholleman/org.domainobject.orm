package org.domainobject.orm.db;

import static org.domainobject.orm.db.StaticColumn.ATTRIBUTE.NAME;
import static org.domainobject.orm.db.StaticColumn.ATTRIBUTE.SIZE;
import static org.domainobject.orm.db.StaticColumn.ATTRIBUTE.TYPE;
import static org.domainobject.orm.db.StaticColumn.ATTRIBUTE.AUTOINCREMENT;
import static org.domainobject.orm.db.StaticColumn.ATTRIBUTE.NULLABLE;
import static org.domainobject.orm.db.StaticColumn.ATTRIBUTE.POSITION;

import java.sql.ResultSet;
import java.sql.SQLException;

class StaticColumn implements Column {

	static enum ATTRIBUTE {
		NAME(4), TYPE(5), SIZE(7), POSITION(17), NULLABLE(18), AUTOINCREMENT(23);

		private final int index;

		ATTRIBUTE(int index)
		{
			this.index = index;
		}
	}

	private final Entity entity;
	private final String name;
	private final int type;
	private final int size;
	private final int position;
	private final boolean nullable;
	private final boolean autoIncrement;

	public StaticColumn(Entity entity, ResultSet rs) throws SQLException
	{
		this.entity = entity;
		name = rs.getString(NAME.index);
		type = rs.getInt(TYPE.index);
		size = rs.getInt(SIZE.index);
		position = rs.getInt(POSITION.index);
		nullable = rs.getString(NULLABLE.index).equals("YES");
		if (rs.getMetaData().getColumnCount() >= AUTOINCREMENT.index)
			autoIncrement = rs.getString(AUTOINCREMENT.index).equals("YES");
		else
			autoIncrement = false;
	}

	public Entity getEntity()
	{
		return entity;
	}

	public String getName()
	{
		return name;
	}

	public int getDataType()
	{
		return type;
	}

	public int getColumnSize()
	{
		return size;
	}

	public int getOrdinalPosition()
	{
		return position;
	}

	public boolean isNullable()
	{
		return nullable;
	}

	public boolean isAutoIncrement()
	{
		return autoIncrement;
	}

	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
			return true;
		if (obj == null || !(obj instanceof StaticColumn))
			return false;
		StaticColumn other = (StaticColumn) obj;
		return (name.equals(other.name) && entity.equals(other.entity));
	}

	@Override
	public int hashCode()
	{
		// TODO
		return System.identityHashCode(this);
	}

}
