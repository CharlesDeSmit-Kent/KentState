using UnityEngine;
using UnityEngine.UI;
using System.Collections;

public class AmmoManager : MonoBehaviour
{
    public static int ammo;        // The player's score.


    Text text;                      


    void Awake()
    {
        // Set up the reference.
        text = GetComponent<Text>();
        // Reset the score.
        ammo = 50;
    }


    void Update()
    {
        // Set the displayed text to be the word "Score" followed by the score value.
        text.text = "Ammo: " + ammo;
        /*PlayerMovement.audioSrc.clip = Resources.Load<AudioClip>("Gun_03");
        PlayerMovement.audioSrc.Play();*/

        if (ammo < 0)
        {
            ammo = 0;
        }
    }
}

