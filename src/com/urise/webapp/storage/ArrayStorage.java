package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    private Resume[] storage = new Resume[10000];
    private int size = 0;

    public void clear() {
        Arrays.fill(storage, 0, size, null);
//        for (int i = 0; i < size; i++){
//            storage[i] = null;
//        }
        size = 0;
    }

    public void save(Resume r) {

        if (getIndex(r.getUuid()) != -1){
            System.out.println("Resume " + r.getUuid() + " not exist");
        } else if(size == storage.length){
            System.out.println("Storage overflow");
        } else {
            storage[size] = r;
            size++;
        }

    }
    public void update(Resume r) {
        int index = getIndex(r.getUuid());
        if (index == -1){
            System.out.println("Resume " + r.getUuid() + " not exist");
        } else {
            storage[index] = r;
        }
    }

    public Resume get(String uuid) {

        int index = getIndex(uuid);
        if (index == -1){
            System.out.println("Resume " + uuid + " not exist");
            return null;
        }
        return storage[index];
    }

    public void delete(String uuid) {
        int index = getIndex(uuid);
        if (index == -1){
            System.out.println("Resume " + uuid + " not exist");

        } else {
            storage[index] = storage[size-1];
            storage[size - 1] = null;
            size--;
               }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    public Resume[] getAll() {
        return Arrays.copyOfRange(storage, 0, size);
//        Resume[] result = new Resume[size];
//        for (int i = 0; i < size; i++){
//            result[i] = storage[i];
//        }
//        return result;
    }

    public int size() {
        return size;
    }

    private int getIndex(String uuid){
        for (int i = 0; i < size; i++){
            if (uuid == storage[i].getUuid()){
                return i;
            }
        }
        return -1;
    }

}
