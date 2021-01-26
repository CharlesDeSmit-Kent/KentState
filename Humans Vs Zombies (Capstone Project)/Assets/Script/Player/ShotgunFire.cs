using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class ShotgunFire : MonoBehaviour
{
    public static AudioSource audioSrc;
    public GameObject bulletPrefab1;
    public GameObject bulletPrefab2;
    public GameObject bulletPrefab3;
    public GameObject bulletPrefab4;
    public GameObject Spread1;
    public GameObject Spread2;
    public GameObject Spread3;
    public GameObject Spread4;
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
                GameObject bulletObject1 = Instantiate(bulletPrefab1);
                bulletObject1.transform.position = Spread1.transform.position + Spread1.transform.forward;
                bulletObject1.transform.forward = Spread1.transform.forward;

                GameObject bulletObject2 = Instantiate(bulletPrefab2);
                bulletObject2.transform.position = Spread2.transform.position + Spread2.transform.forward;
                bulletObject2.transform.forward = Spread2.transform.forward;

                GameObject bulletObject3 = Instantiate(bulletPrefab3);
                bulletObject3.transform.position = Spread3.transform.position + Spread3.transform.forward;
                bulletObject3.transform.forward = Spread3.transform.forward;

                GameObject bulletObject4 = Instantiate(bulletPrefab4);
                bulletObject4.transform.position = Spread4.transform.position + Spread4.transform.forward;
                bulletObject4.transform.forward = Spread1.transform.forward;


                AmmoManager.ammo -= 4;
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
