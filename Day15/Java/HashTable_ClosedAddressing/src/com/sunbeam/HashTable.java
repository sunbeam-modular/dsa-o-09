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
	private List<Entry> table[];
	
	public HashTable(int size) {
		SIZE = size;
		table = new List[SIZE];
		for(int i = 0 ; i < SIZE ; i++)
			table[i] = new LinkedList<HashTable.Entry>();
	}
	
	public int h(int k) {
		return k % SIZE;
	}
	
	public void put(int key, String value) {
		//1. find slot for given key
		int slot = h(key);
		
		//2. if key already exist, then update old value corresponding to the key
		if(!table[slot].isEmpty()) {
			for(Entry e : table[slot]) {
				if(key == e.key) {
					e.value = value;
					return;
				}
			}
		}
		
		//3. if key doesn't exist, then  create new entry and add it on corresponding slot
		Entry e = new Entry(key, value);
		table[slot].add(e);
	}
	
	public String get(int key) {
		//1. find slot for given key
		int slot = h(key);
		
		//2. if key exist, return corresponding value
		if(!table[slot].isEmpty()) {
			for(Entry e : table[slot]) {
				if(key == e.key) {
					return e.value;
				}
			}
		}
		
		//3. if key is not found
		return null;
	}
	
}














