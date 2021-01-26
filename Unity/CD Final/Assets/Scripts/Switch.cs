using UnityEngine;
using System.Collections;

public class Switch : MonoBehaviour {

    public GameObject door;
    private Animator anim;
    private AudioSource sound;

	// Use this for initialization
	void Start () {
        anim = GetComponent<Animator>();
        sound = GetComponent<AudioSource>();
	}
	
	// Update is called once per frame
	void Update () {

        if (anim.GetBool("SwitchOn") == false) {

            sound.Stop();
            Destroy(door, 1f);
        }
	}
}
