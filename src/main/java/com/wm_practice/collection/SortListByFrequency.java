package com.wm_practice.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


/***
 * Problem:
 * Sort element in list based on frequency and occurrence if frequency same for 2
 * 
 *
 */
public class SortListByFrequency {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> lists = new LinkedList<>();
		lists.add(1);
		lists.add(2);
		lists.add(3);
		lists.add(1);
		lists.add(1);
		lists.add(4);
		lists.add(2);
		lists.add(5);
		lists.add(5);
		System.out.println("before sorting list::"+lists);
		sort(lists);
	}
	
	static void sort(List<Integer> list) {
		Map<Integer,Integer> map = new HashMap<>();

	list.forEach(key->{
		if(map.containsKey(key))
			map.put(key, map.get(key)+1);
		else
			map.put(key, 1);
	});
	System.out.println("====map==before sorting=="+map);
	
LinkedHashMap<Integer,Integer> linkMap =map.entrySet().stream().sorted(Map.Entry.<Integer,Integer>comparingByValue().reversed()).collect(Collectors.toMap(Map.Entry::getKey,Map.Entry::getValue,
		(e1,e2)->e1,LinkedHashMap:: new));
		System.out.println("===map after sort==="+linkMap);
		
		List<Map.Entry<Integer,Integer>> list1= new ArrayList<>(map.entrySet());
				
		Collections.sort(list1,(l1,l2)->l2.getValue().compareTo(l1.getValue()));
		
		System.out.println("====list==after sorting=="+list1);

		 List<Integer> listSorted = new LinkedList<>();
		 for(Map.Entry<Integer, Integer> entry:linkMap.entrySet()) {
			int frequency = entry.getValue();
			while(frequency>=1) {
				listSorted.add(entry.getKey());
				frequency--;
			}
		 }
		 System.out.println("sorted list :"+listSorted);
	}

}
