package com.rareprob.core_pulgin.payment.in_app_purchase.data.local;

import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.rareprob.core_pulgin.payment.in_app_purchase.data.local.entity.InAppPurchaseEntity;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

@SuppressWarnings({"unchecked", "deprecation"})
public final class IapBillingDao_Impl implements IapBillingDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<InAppPurchaseEntity> __insertionAdapterOfInAppPurchaseEntity;

  private final EntityDeletionOrUpdateAdapter<InAppPurchaseEntity> __deletionAdapterOfInAppPurchaseEntity;

  private final EntityDeletionOrUpdateAdapter<InAppPurchaseEntity> __updateAdapterOfInAppPurchaseEntity;

  public IapBillingDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfInAppPurchaseEntity = new EntityInsertionAdapter<InAppPurchaseEntity>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `InAppPurchaseEntity` (`appId`,`productId`,`productType`,`productName`,`active`,`isPurchased`) VALUES (?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, InAppPurchaseEntity value) {
        if (value.getAppId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getAppId());
        }
        if (value.getProductId() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getProductId());
        }
        if (value.getProductType() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getProductType());
        }
        if (value.getProductName() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getProductName());
        }
        if (value.getActive() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getActive());
        }
        final int _tmp;
        _tmp = value.isPurchased() ? 1 : 0;
        stmt.bindLong(6, _tmp);
      }
    };
    this.__deletionAdapterOfInAppPurchaseEntity = new EntityDeletionOrUpdateAdapter<InAppPurchaseEntity>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `InAppPurchaseEntity` WHERE `appId` = ? AND `productId` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, InAppPurchaseEntity value) {
        if (value.getAppId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getAppId());
        }
        if (value.getProductId() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getProductId());
        }
      }
    };
    this.__updateAdapterOfInAppPurchaseEntity = new EntityDeletionOrUpdateAdapter<InAppPurchaseEntity>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `InAppPurchaseEntity` SET `appId` = ?,`productId` = ?,`productType` = ?,`productName` = ?,`active` = ?,`isPurchased` = ? WHERE `appId` = ? AND `productId` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, InAppPurchaseEntity value) {
        if (value.getAppId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getAppId());
        }
        if (value.getProductId() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getProductId());
        }
        if (value.getProductType() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getProductType());
        }
        if (value.getProductName() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getProductName());
        }
        if (value.getActive() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getActive());
        }
        final int _tmp;
        _tmp = value.isPurchased() ? 1 : 0;
        stmt.bindLong(6, _tmp);
        if (value.getAppId() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getAppId());
        }
        if (value.getProductId() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getProductId());
        }
      }
    };
  }

  @Override
  public Object insert(final InAppPurchaseEntity obj,
      final Continuation<? super Unit> continuation) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfInAppPurchaseEntity.insert(obj);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, continuation);
  }

  @Override
  public Object insert(final InAppPurchaseEntity[] obj,
      final Continuation<? super Unit> continuation) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfInAppPurchaseEntity.insert(obj);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, continuation);
  }

  @Override
  public Object delete(final InAppPurchaseEntity obj,
      final Continuation<? super Unit> continuation) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __deletionAdapterOfInAppPurchaseEntity.handle(obj);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, continuation);
  }

  @Override
  public Object update(final InAppPurchaseEntity obj,
      final Continuation<? super Unit> continuation) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __updateAdapterOfInAppPurchaseEntity.handle(obj);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, continuation);
  }

  @Override
  public Object getInAppPurchases(
      final Continuation<? super List<InAppPurchaseEntity>> continuation) {
    final String _sql = "SELECT * FROM InAppPurchaseEntity";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<List<InAppPurchaseEntity>>() {
      @Override
      public List<InAppPurchaseEntity> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfAppId = CursorUtil.getColumnIndexOrThrow(_cursor, "appId");
          final int _cursorIndexOfProductId = CursorUtil.getColumnIndexOrThrow(_cursor, "productId");
          final int _cursorIndexOfProductType = CursorUtil.getColumnIndexOrThrow(_cursor, "productType");
          final int _cursorIndexOfProductName = CursorUtil.getColumnIndexOrThrow(_cursor, "productName");
          final int _cursorIndexOfActive = CursorUtil.getColumnIndexOrThrow(_cursor, "active");
          final int _cursorIndexOfIsPurchased = CursorUtil.getColumnIndexOrThrow(_cursor, "isPurchased");
          final List<InAppPurchaseEntity> _result = new ArrayList<InAppPurchaseEntity>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final InAppPurchaseEntity _item;
            final String _tmpAppId;
            if (_cursor.isNull(_cursorIndexOfAppId)) {
              _tmpAppId = null;
            } else {
              _tmpAppId = _cursor.getString(_cursorIndexOfAppId);
            }
            final String _tmpProductId;
            if (_cursor.isNull(_cursorIndexOfProductId)) {
              _tmpProductId = null;
            } else {
              _tmpProductId = _cursor.getString(_cursorIndexOfProductId);
            }
            final String _tmpProductType;
            if (_cursor.isNull(_cursorIndexOfProductType)) {
              _tmpProductType = null;
            } else {
              _tmpProductType = _cursor.getString(_cursorIndexOfProductType);
            }
            final String _tmpProductName;
            if (_cursor.isNull(_cursorIndexOfProductName)) {
              _tmpProductName = null;
            } else {
              _tmpProductName = _cursor.getString(_cursorIndexOfProductName);
            }
            final String _tmpActive;
            if (_cursor.isNull(_cursorIndexOfActive)) {
              _tmpActive = null;
            } else {
              _tmpActive = _cursor.getString(_cursorIndexOfActive);
            }
            final boolean _tmpIsPurchased;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfIsPurchased);
            _tmpIsPurchased = _tmp != 0;
            _item = new InAppPurchaseEntity(_tmpAppId,_tmpProductId,_tmpProductType,_tmpProductName,_tmpActive,_tmpIsPurchased);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, continuation);
  }

  @Override
  public Object getAlreadyOwnedProduct(final String appId, final boolean isPurchased,
      final Continuation<? super List<InAppPurchaseEntity>> continuation) {
    final String _sql = "SELECT * FROM InAppPurchaseEntity where appId = ? and isPurchased = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    if (appId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, appId);
    }
    _argIndex = 2;
    final int _tmp;
    _tmp = isPurchased ? 1 : 0;
    _statement.bindLong(_argIndex, _tmp);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<List<InAppPurchaseEntity>>() {
      @Override
      public List<InAppPurchaseEntity> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfAppId = CursorUtil.getColumnIndexOrThrow(_cursor, "appId");
          final int _cursorIndexOfProductId = CursorUtil.getColumnIndexOrThrow(_cursor, "productId");
          final int _cursorIndexOfProductType = CursorUtil.getColumnIndexOrThrow(_cursor, "productType");
          final int _cursorIndexOfProductName = CursorUtil.getColumnIndexOrThrow(_cursor, "productName");
          final int _cursorIndexOfActive = CursorUtil.getColumnIndexOrThrow(_cursor, "active");
          final int _cursorIndexOfIsPurchased = CursorUtil.getColumnIndexOrThrow(_cursor, "isPurchased");
          final List<InAppPurchaseEntity> _result = new ArrayList<InAppPurchaseEntity>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final InAppPurchaseEntity _item;
            final String _tmpAppId;
            if (_cursor.isNull(_cursorIndexOfAppId)) {
              _tmpAppId = null;
            } else {
              _tmpAppId = _cursor.getString(_cursorIndexOfAppId);
            }
            final String _tmpProductId;
            if (_cursor.isNull(_cursorIndexOfProductId)) {
              _tmpProductId = null;
            } else {
              _tmpProductId = _cursor.getString(_cursorIndexOfProductId);
            }
            final String _tmpProductType;
            if (_cursor.isNull(_cursorIndexOfProductType)) {
              _tmpProductType = null;
            } else {
              _tmpProductType = _cursor.getString(_cursorIndexOfProductType);
            }
            final String _tmpProductName;
            if (_cursor.isNull(_cursorIndexOfProductName)) {
              _tmpProductName = null;
            } else {
              _tmpProductName = _cursor.getString(_cursorIndexOfProductName);
            }
            final String _tmpActive;
            if (_cursor.isNull(_cursorIndexOfActive)) {
              _tmpActive = null;
            } else {
              _tmpActive = _cursor.getString(_cursorIndexOfActive);
            }
            final boolean _tmpIsPurchased;
            final int _tmp_1;
            _tmp_1 = _cursor.getInt(_cursorIndexOfIsPurchased);
            _tmpIsPurchased = _tmp_1 != 0;
            _item = new InAppPurchaseEntity(_tmpAppId,_tmpProductId,_tmpProductType,_tmpProductName,_tmpActive,_tmpIsPurchased);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, continuation);
  }

  @Override
  public Object getInAppPurchaseById(final String appId, final String productId,
      final Continuation<? super InAppPurchaseEntity> continuation) {
    final String _sql = "SELECT * FROM InAppPurchaseEntity where appId = ? and productId = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    if (appId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, appId);
    }
    _argIndex = 2;
    if (productId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, productId);
    }
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<InAppPurchaseEntity>() {
      @Override
      public InAppPurchaseEntity call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfAppId = CursorUtil.getColumnIndexOrThrow(_cursor, "appId");
          final int _cursorIndexOfProductId = CursorUtil.getColumnIndexOrThrow(_cursor, "productId");
          final int _cursorIndexOfProductType = CursorUtil.getColumnIndexOrThrow(_cursor, "productType");
          final int _cursorIndexOfProductName = CursorUtil.getColumnIndexOrThrow(_cursor, "productName");
          final int _cursorIndexOfActive = CursorUtil.getColumnIndexOrThrow(_cursor, "active");
          final int _cursorIndexOfIsPurchased = CursorUtil.getColumnIndexOrThrow(_cursor, "isPurchased");
          final InAppPurchaseEntity _result;
          if(_cursor.moveToFirst()) {
            final String _tmpAppId;
            if (_cursor.isNull(_cursorIndexOfAppId)) {
              _tmpAppId = null;
            } else {
              _tmpAppId = _cursor.getString(_cursorIndexOfAppId);
            }
            final String _tmpProductId;
            if (_cursor.isNull(_cursorIndexOfProductId)) {
              _tmpProductId = null;
            } else {
              _tmpProductId = _cursor.getString(_cursorIndexOfProductId);
            }
            final String _tmpProductType;
            if (_cursor.isNull(_cursorIndexOfProductType)) {
              _tmpProductType = null;
            } else {
              _tmpProductType = _cursor.getString(_cursorIndexOfProductType);
            }
            final String _tmpProductName;
            if (_cursor.isNull(_cursorIndexOfProductName)) {
              _tmpProductName = null;
            } else {
              _tmpProductName = _cursor.getString(_cursorIndexOfProductName);
            }
            final String _tmpActive;
            if (_cursor.isNull(_cursorIndexOfActive)) {
              _tmpActive = null;
            } else {
              _tmpActive = _cursor.getString(_cursorIndexOfActive);
            }
            final boolean _tmpIsPurchased;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfIsPurchased);
            _tmpIsPurchased = _tmp != 0;
            _result = new InAppPurchaseEntity(_tmpAppId,_tmpProductId,_tmpProductType,_tmpProductName,_tmpActive,_tmpIsPurchased);
          } else {
            _result = null;
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, continuation);
  }

  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
