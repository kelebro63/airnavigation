package com.example.airnavigate.Dao;

import java.util.List;
import java.util.ArrayList;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;

import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.Property;
import de.greenrobot.dao.internal.SqlUtils;
import de.greenrobot.dao.internal.DaoConfig;
import de.greenrobot.dao.query.Query;
import de.greenrobot.dao.query.QueryBuilder;

import com.example.airnavigate.Dao.Voting;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "VOTING".
*/
public class VotingDao extends AbstractDao<Voting, Void> {

    public static final String TABLENAME = "VOTING";

    /**
     * Properties of entity Voting.<br/>
     * Can be used for QueryBuilder and for referencing column names.
    */
    public static class Properties {
        public final static Property Id = new Property(0, Integer.class, "id", false, "ID");
        public final static Property Subject = new Property(1, String.class, "subject", false, "SUBJECT");
        public final static Property VoteDate = new Property(2, String.class, "voteDate", false, "VOTE_DATE");
        public final static Property VoteCount = new Property(3, Integer.class, "voteCount", false, "VOTE_COUNT");
        public final static Property ForCount = new Property(4, Integer.class, "forCount", false, "FOR_COUNT");
        public final static Property AgainstCount = new Property(5, Integer.class, "againstCount", false, "AGAINST_COUNT");
        public final static Property AbstainCount = new Property(6, Integer.class, "abstainCount", false, "ABSTAIN_COUNT");
        public final static Property AbsentCount = new Property(7, Integer.class, "absentCount", false, "ABSENT_COUNT");
        public final static Property ResultType = new Property(8, String.class, "resultType", false, "RESULT_TYPE");
        public final static Property Result = new Property(9, Boolean.class, "result", false, "RESULT");
        public final static Property VotingResultId = new Property(10, long.class, "votingResultId", false, "VOTING_RESULT_ID");
    };

    private DaoSession daoSession;

    private Query<Voting> votingResult_VotesQuery;

    public VotingDao(DaoConfig config) {
        super(config);
    }
    
    public VotingDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
        this.daoSession = daoSession;
    }

    /** Creates the underlying database table. */
    public static void createTable(SQLiteDatabase db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"VOTING\" (" + //
                "\"ID\" INTEGER," + // 0: id
                "\"SUBJECT\" TEXT," + // 1: subject
                "\"VOTE_DATE\" TEXT," + // 2: voteDate
                "\"VOTE_COUNT\" INTEGER," + // 3: voteCount
                "\"FOR_COUNT\" INTEGER," + // 4: forCount
                "\"AGAINST_COUNT\" INTEGER," + // 5: againstCount
                "\"ABSTAIN_COUNT\" INTEGER," + // 6: abstainCount
                "\"ABSENT_COUNT\" INTEGER," + // 7: absentCount
                "\"RESULT_TYPE\" TEXT," + // 8: resultType
                "\"RESULT\" INTEGER," + // 9: result
                "\"VOTING_RESULT_ID\" INTEGER NOT NULL );"); // 10: votingResultId
    }

    /** Drops the underlying database table. */
    public static void dropTable(SQLiteDatabase db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"VOTING\"";
        db.execSQL(sql);
    }

    /** @inheritdoc */
    @Override
    protected void bindValues(SQLiteStatement stmt, Voting entity) {
        stmt.clearBindings();
 
        Integer id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        String subject = entity.getSubject();
        if (subject != null) {
            stmt.bindString(2, subject);
        }
 
        String voteDate = entity.getVoteDate();
        if (voteDate != null) {
            stmt.bindString(3, voteDate);
        }
 
        Integer voteCount = entity.getVoteCount();
        if (voteCount != null) {
            stmt.bindLong(4, voteCount);
        }
 
        Integer forCount = entity.getForCount();
        if (forCount != null) {
            stmt.bindLong(5, forCount);
        }
 
        Integer againstCount = entity.getAgainstCount();
        if (againstCount != null) {
            stmt.bindLong(6, againstCount);
        }
 
        Integer abstainCount = entity.getAbstainCount();
        if (abstainCount != null) {
            stmt.bindLong(7, abstainCount);
        }
 
        Integer absentCount = entity.getAbsentCount();
        if (absentCount != null) {
            stmt.bindLong(8, absentCount);
        }
 
        String resultType = entity.getResultType();
        if (resultType != null) {
            stmt.bindString(9, resultType);
        }
 
        Boolean result = entity.getResult();
        if (result != null) {
            stmt.bindLong(10, result ? 1L: 0L);
        }
        stmt.bindLong(11, entity.getVotingResultId());
    }

    @Override
    protected void attachEntity(Voting entity) {
        super.attachEntity(entity);
        entity.__setDaoSession(daoSession);
    }

    /** @inheritdoc */
    @Override
    public Void readKey(Cursor cursor, int offset) {
        return null;
    }    

    /** @inheritdoc */
    @Override
    public Voting readEntity(Cursor cursor, int offset) {
        Voting entity = new Voting( //
            cursor.isNull(offset + 0) ? null : cursor.getInt(offset + 0), // id
            cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1), // subject
            cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2), // voteDate
            cursor.isNull(offset + 3) ? null : cursor.getInt(offset + 3), // voteCount
            cursor.isNull(offset + 4) ? null : cursor.getInt(offset + 4), // forCount
            cursor.isNull(offset + 5) ? null : cursor.getInt(offset + 5), // againstCount
            cursor.isNull(offset + 6) ? null : cursor.getInt(offset + 6), // abstainCount
            cursor.isNull(offset + 7) ? null : cursor.getInt(offset + 7), // absentCount
            cursor.isNull(offset + 8) ? null : cursor.getString(offset + 8), // resultType
            cursor.isNull(offset + 9) ? null : cursor.getShort(offset + 9) != 0, // result
            cursor.getLong(offset + 10) // votingResultId
        );
        return entity;
    }
     
    /** @inheritdoc */
    @Override
    public void readEntity(Cursor cursor, Voting entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getInt(offset + 0));
        entity.setSubject(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setVoteDate(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setVoteCount(cursor.isNull(offset + 3) ? null : cursor.getInt(offset + 3));
        entity.setForCount(cursor.isNull(offset + 4) ? null : cursor.getInt(offset + 4));
        entity.setAgainstCount(cursor.isNull(offset + 5) ? null : cursor.getInt(offset + 5));
        entity.setAbstainCount(cursor.isNull(offset + 6) ? null : cursor.getInt(offset + 6));
        entity.setAbsentCount(cursor.isNull(offset + 7) ? null : cursor.getInt(offset + 7));
        entity.setResultType(cursor.isNull(offset + 8) ? null : cursor.getString(offset + 8));
        entity.setResult(cursor.isNull(offset + 9) ? null : cursor.getShort(offset + 9) != 0);
        entity.setVotingResultId(cursor.getLong(offset + 10));
     }
    
    /** @inheritdoc */
    @Override
    protected Void updateKeyAfterInsert(Voting entity, long rowId) {
        // Unsupported or missing PK type
        return null;
    }
    
    /** @inheritdoc */
    @Override
    public Void getKey(Voting entity) {
        return null;
    }

    /** @inheritdoc */
    @Override    
    protected boolean isEntityUpdateable() {
        return true;
    }
    
    /** Internal query to resolve the "votes" to-many relationship of VotingResult. */
    public List<Voting> _queryVotingResult_Votes(long votingResultId) {
        synchronized (this) {
            if (votingResult_VotesQuery == null) {
                QueryBuilder<Voting> queryBuilder = queryBuilder();
                queryBuilder.where(Properties.VotingResultId.eq(null));
                votingResult_VotesQuery = queryBuilder.build();
            }
        }
        Query<Voting> query = votingResult_VotesQuery.forCurrentThread();
        query.setParameter(0, votingResultId);
        return query.list();
    }

    private String selectDeep;

    protected String getSelectDeep() {
        if (selectDeep == null) {
            StringBuilder builder = new StringBuilder("SELECT ");
            SqlUtils.appendColumns(builder, "T", getAllColumns());
            builder.append(',');
            SqlUtils.appendColumns(builder, "T0", daoSession.getVotingResultDao().getAllColumns());
            builder.append(" FROM VOTING T");
            builder.append(" LEFT JOIN VOTING_RESULT T0 ON T.\"VOTING_RESULT_ID\"=T0.\"PAGE\"");
            builder.append(' ');
            selectDeep = builder.toString();
        }
        return selectDeep;
    }
    
    protected Voting loadCurrentDeep(Cursor cursor, boolean lock) {
        Voting entity = loadCurrent(cursor, 0, lock);
        int offset = getAllColumns().length;

        VotingResult votingResult = loadCurrentOther(daoSession.getVotingResultDao(), cursor, offset);
         if(votingResult != null) {
            entity.setVotingResult(votingResult);
        }

        return entity;    
    }

    public Voting loadDeep(Long key) {
        assertSinglePk();
        if (key == null) {
            return null;
        }

        StringBuilder builder = new StringBuilder(getSelectDeep());
        builder.append("WHERE ");
        SqlUtils.appendColumnsEqValue(builder, "T", getPkColumns());
        String sql = builder.toString();
        
        String[] keyArray = new String[] { key.toString() };
        Cursor cursor = db.rawQuery(sql, keyArray);
        
        try {
            boolean available = cursor.moveToFirst();
            if (!available) {
                return null;
            } else if (!cursor.isLast()) {
                throw new IllegalStateException("Expected unique result, but count was " + cursor.getCount());
            }
            return loadCurrentDeep(cursor, true);
        } finally {
            cursor.close();
        }
    }
    
    /** Reads all available rows from the given cursor and returns a list of new ImageTO objects. */
    public List<Voting> loadAllDeepFromCursor(Cursor cursor) {
        int count = cursor.getCount();
        List<Voting> list = new ArrayList<Voting>(count);
        
        if (cursor.moveToFirst()) {
            if (identityScope != null) {
                identityScope.lock();
                identityScope.reserveRoom(count);
            }
            try {
                do {
                    list.add(loadCurrentDeep(cursor, false));
                } while (cursor.moveToNext());
            } finally {
                if (identityScope != null) {
                    identityScope.unlock();
                }
            }
        }
        return list;
    }
    
    protected List<Voting> loadDeepAllAndCloseCursor(Cursor cursor) {
        try {
            return loadAllDeepFromCursor(cursor);
        } finally {
            cursor.close();
        }
    }
    

    /** A raw-style query where you can pass any WHERE clause and arguments. */
    public List<Voting> queryDeep(String where, String... selectionArg) {
        Cursor cursor = db.rawQuery(getSelectDeep() + where, selectionArg);
        return loadDeepAllAndCloseCursor(cursor);
    }
 
}
