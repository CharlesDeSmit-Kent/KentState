﻿using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.Events;

public class TriggerEvents : MonoBehaviour {

	public UnityEvent onEnterTrigger;

	private void OnTriggerEnter ( Collider argOther )
	{
		onEnterTrigger.Invoke();
	}
}