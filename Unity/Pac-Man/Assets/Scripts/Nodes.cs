using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class Nodes : MonoBehaviour {

    public Nodes[] neighbors;
    public Vector2[] directions;

	void Start () {
        directions = new Vector2[neighbors.Length];
        for (int i = 0; i < neighbors.Length; i++)
        {
            Nodes neighbor = neighbors[i];
            Vector2 temp = neighbor.transform.localPosition - transform.localPosition;
            directions[i] = temp.normalized;
        }
        
	}
}
