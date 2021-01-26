using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class DisableTimer : MonoBehaviour {

	public float disableAfter = 0;

	private void OnEnable ()
	{
		if ( disableAfter > 0 )
		{
			Invoke( "Disable", disableAfter );
		}
	}

	private void Disable ()
	{
		gameObject.SetActive( false );
	}
}
