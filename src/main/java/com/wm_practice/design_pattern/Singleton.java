package com.wm_practice.design_pattern;

import java.io.Serializable;

class Singleton implements Cloneable, Serializable {
	private static Singleton singleton = null;

	public String s;

	private Singleton() {
		s = "Single oblject created";
	}

	public static Singleton getSingleton() {
		if (singleton == null) {
			synchronized (Singleton.class) {
				if (singleton == null) {
					singleton = new Singleton();
				}

			}
		}

		return singleton;
	}

	@Override
	protected Object clone() {
		return singleton;
	}

	protected Object readResolve() {
		return singleton;
	}

}