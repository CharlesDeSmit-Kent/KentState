using UnityEngine;

public class WeaponSwitch : MonoBehaviour
{
    //Determine Current Weapon

    public int CurrentWeapon = 0;

    // Start is called before the first frame update
    void Start()
    {
        SelectWeapon();
        
    }

    // Update is called once per frame
    void Update()
    {
        int PreviousWeapon = CurrentWeapon;

        if (Input.GetAxis("Mouse ScrollWheel") > 0f)
        {
            if (CurrentWeapon >= transform.childCount - 1)
            {
                CurrentWeapon = 0;
            }
            else
            {
                CurrentWeapon++;
            }
            if (PreviousWeapon != CurrentWeapon)
            {
                SelectWeapon();
            }
        }

        if (Input.GetAxis("Mouse ScrollWheel") < 0f)
        {
            if (CurrentWeapon <= 0)
            {
                CurrentWeapon = transform.childCount - 1;
            }
            else
            {
                CurrentWeapon--;

            }
            if (PreviousWeapon != CurrentWeapon)
            {
                SelectWeapon();
            }
        }


        if (Input.GetKeyDown(KeyCode.Alpha1))
        {
            CurrentWeapon = 0;
            SelectWeapon();
        }

        if (Input.GetKeyDown(KeyCode.Alpha2) && transform.childCount >= 2)
        {
            CurrentWeapon = 1;
            SelectWeapon();
        }

        if (Input.GetKeyDown(KeyCode.Alpha3) && transform.childCount >= 3)
        {
            CurrentWeapon = 2;
            SelectWeapon();
        }
    }

    void SelectWeapon()
    {
        int i = 0;
        foreach (Transform weapon in transform)
        {
            if (i == CurrentWeapon)
            {
                weapon.gameObject.SetActive(true);
            }

            else
            {
                weapon.gameObject.SetActive(false);
            }

            i++;
        }
    }
}
