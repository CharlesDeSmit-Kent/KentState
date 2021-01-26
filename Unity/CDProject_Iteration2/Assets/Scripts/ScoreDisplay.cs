using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.UI;


public class ScoreDisplay : MonoBehaviour {

    int objectives;
    Text text;

	// Use this for initialization
	void Awake () {
        text = GetComponent<Text>();
        objectives = 0;
	}
	
	// Update is called once per frame
	void Update () {
        objectives = GameObject.Find("GameManager").GetComponent<GameControl>().objectives;
        text.text = "Objectives: " + objectives;
    }
}
