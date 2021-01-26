using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class GameBoard : MonoBehaviour {

    private static int width = 40;
    private static int height = 31;

    public int totalPellets = 0;
    public int score = 0;

    public GameObject[,] board = new GameObject[width, height];

	// Use this for initialization
	void Start () {
        Object[] objects = GameObject.FindObjectsOfType (typeof(GameObject));

        foreach(GameObject o in objects)
        {
            Vector2 pos = o.transform.position;
            pos.x += 20;
            pos.y += 15;

            //Debug.Log((int)pos.x + " " + (int)pos.y);
            if (o.name != "pacman" && o.name != "Nodes" && o.name != "NonNodes" && o.name != "Maze" && o.name != "Pellets")
            {

                if (o.GetComponent<Tile>() != null)
                {
                    if(o.GetComponent<Tile>().isPellet)
                    {
                        totalPellets++;
                    }
                }
                board[((int)pos.x), ((int)pos.y)] = o;
            }
            else
            {
                Debug.Log("Found PacMan at: " + pos);
            }
        }
	}
	
	// Update is called once per frame
	void Update () {
		
	}
}
