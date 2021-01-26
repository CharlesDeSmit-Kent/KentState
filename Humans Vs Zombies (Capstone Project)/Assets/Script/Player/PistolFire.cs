using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class PistolFire : MonoBehaviour
{
    public static AudioSource audioSrc;
    public GameObject bulletPrefab;
    public Camera playerCam;
    // Start is called before the first frame update
    void Start()
    {
        audioSrc = GetComponent<AudioSource>();
    }

    // Update is called once per frame
    void Update()
    {
        if (Input.GetMouseButtonDown(0))
        {
            if (AmmoManager.ammo > 0)
            {
                GameObject bulletObject = Instantiate(bulletPrefab);
                bulletObject.transform.position = playerCam.transform.position + playerCam.transform.forward;
                bulletObject.transform.forward = playerCam.transform.forward;
                AmmoManager.ammo -= 1;
                audioSrc.clip = Resources.Load<AudioClip>("Gun_02");
                audioSrc.Play();

            }

            else if (AmmoManager.ammo <= 0)
            {
                audioSrc.clip = Resources.Load<AudioClip>("Gun_04");
                audioSrc.Play();
            }
        }
    }
}
