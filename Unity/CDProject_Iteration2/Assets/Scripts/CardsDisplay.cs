using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.UI;


public class CardsDisplay : MonoBehaviour {

    int cards;
    Text text;

    // Use this for initialization
    void Awake()
    {
        text = GetComponent<Text>();
        cards = 0;
    }

    // Update is called once per frame
    void Update()
    {
        cards = GameObject.Find("GameManager").GetComponent<GameControl>().cards;
        text.text = "Cards: " + cards;
    }
}
