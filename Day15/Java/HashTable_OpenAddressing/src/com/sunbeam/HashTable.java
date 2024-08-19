package com.sunbeam;

import java.util.LinkedList;
import java.util.List;

public class HashTable {
	static class Entry{
		private int key;
		private String value;
		public Entry(int key, String value) {
			this.key = key;
			this.value = value;
		}
	}
	
	private int SIZE;
	private Entry table[];
	
	public HashTable(int size) {
		SIZE = size;
		table = new Entry[SIZE];
	}
	
	public int h(int k) {
		return k % SIZE;
	}
	
	public int h(int k, int i) {
		return (h(k) + i) % SIZE;
	}
	
	public void put(int key, String value) {
		//1. find slot for given key
		int slot = h(key);
		int i = 1;
		
		//2. if key already exist, then update old value corresponding to the key
		while(table[slot] != null) {
			if(key == table[slot].key) {
				table[slot].value = value;
				return;
			}
			// find next free slot
			slot = h(key, i++);
			
		}
		
		//3. if key doesn't exist, then  create new entry and add it on corresponding slot
		Entry e = new Entry(key, value);
		table[slot] = e;
	}
	
	public String get(int key) {
		//1. find slot for given key
		int slot = h(key);
		int i = 1;

		//2. if key exist, then return value
		while(table[slot] != null) {
			if(key == table[slot].key) {
				return table[slot].value;
			}
			// find next free slot
			slot = h(key, i++);

		}

		//3. if key doesn't exist
		return null;
	}
	
}














