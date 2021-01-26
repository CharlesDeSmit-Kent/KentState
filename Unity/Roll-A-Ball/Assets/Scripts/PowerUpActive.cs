using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class PowerUpActive : MonoBehaviour {
    public bool powerUpActive;
    public float activeTimer = 0.0f;

	// Use this for initialization
	void Start () {
        powerUpActive = false;
        activeTimer = 15.0f;
	}
	
	// Update is called once per frame
	void Update () {
        if (powerUpActive && activeTimer > 0)
            activeTimer -= Time.deltaTime;
        if (powerUpActive && activeTimer <= 0)
        {
            powerUpActive = false;
            activeTimer = 15.0f;
        }
    }
}
