package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

public abstract class AbstractArrayStorage implements Storage  {
    protected static final int STORAGE_LIMIT = 100000;
    protected Resume[] storage = new Resume[STORAGE_LIMIT];
    protected int size = 0;

    public int size() {
        return size;
    }
}
