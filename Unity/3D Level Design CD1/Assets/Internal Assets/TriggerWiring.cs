using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.Events;

public class TriggerWiring : MonoBehaviour {

	public UnityEvent onEnter;
	public UnityEvent onExit;

	public void OnTriggerEnter (Collider argOther )
	{
		if ( argOther.tag == "Player" )
		{
			onEnter.Invoke();
		}
	}

	public void OnTriggerExit ( Collider argOther )
	{
		if ( argOther.tag == "Player" )
		{
			onExit.Invoke();
		}
	}
}
