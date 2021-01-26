using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.UI;

public class MissionWaypoint : MonoBehaviour
{
    // Indicator icon
    public Image img;
    // The target (location, enemy, etc..)
    public Transform target;
    // UI Text to display the distance

    public Transform[] Locations;

    public Text meter;
    // To adjust the position of the icon
    public Vector3 offset;

    public static int LocationIndex;


    private void Start()
    {
        LocationIndex = Random.Range(0, Locations.Length);
        target = Locations[LocationIndex].transform;
       
    }

    private void Update()
    {
        // Giving limits to the icon so it sticks on the screen
        // Below calculations witht the assumption that the icon anchor point is in the middle
        // Minimum X position: half of the icon width
        float minX = img.GetPixelAdjustedRect().width / 2;
        // Maximum X position: screen width - half of the icon width
        float maxX = Screen.width - minX;

        // Minimum Y position: half of the height
        float minY = img.GetPixelAdjustedRect().height / 2;
        // Maximum Y position: screen height - half of the icon height
        float maxY = Screen.height - minY;

        // Temporary variable to store the converted position from 3D world point to 2D screen point
        Vector2 pos = Camera.main.WorldToScreenPoint(target.position + offset);

        // Check if the target is behind us, to only show the icon once the target is in front
        if (Vector3.Dot((target.position - transform.position), transform.forward) < 0)
        {
            // Check if the target is on the left side of the screen
            if (pos.x < Screen.width / 2)
            {
                // Place it on the right (Since it's behind the player, it's the opposite)
                pos.x = maxX;
            }
            else
            {
                // Place it on the left side
                pos.x = minX;
            }
        }

        // Limit the X and Y positions
        pos.x = Mathf.Clamp(pos.x, minX, maxX);
        pos.y = Mathf.Clamp(pos.y, minY, maxY);

        // Update the marker's position
        img.transform.position = pos;
        // Change the meter text to the distance with the meter unit 'm'
        meter.text = ((int)Vector3.Distance(target.position, transform.position)).ToString() + "m";


    }

    private void OnTriggerEnter(Collider other)
    {
        if (other.gameObject.tag == "Prentice")
        {
            if (LocationIndex == 0)
            {
                LocationIndex = Random.Range(0, Locations.Length);
                target = Locations[LocationIndex].transform;
                ScoreManager.score += 200;
                AmmoManager.ammo += 20;
            }
        }


        if (other.gameObject.tag == "SC")
        {
            if (LocationIndex == 1)
            {
                LocationIndex = Random.Range(0, Locations.Length);
                target = Locations[LocationIndex].transform;
                ScoreManager.score += 200;
                AmmoManager.ammo += 20;
            }
        }

        if (other.gameObject.tag == "GA")
        {
            if (LocationIndex == 2)
            {
                LocationIndex = Random.Range(0, Locations.Length);
                target = Locations[LocationIndex].transform;
                ScoreManager.score += 200;
                AmmoManager.ammo += 20;
            }
        }

        if (other.gameObject.tag == "MACC")
        {
            if (LocationIndex == 3)
            {
                LocationIndex = Random.Range(0, Locations.Length);
                target = Locations[LocationIndex].transform;
                ScoreManager.score += 200;
                AmmoManager.ammo += 20;
            }
        }

        if (other.gameObject.tag == "HC")
        {
            if (LocationIndex == 4)
            {
                LocationIndex = Random.Range(0, Locations.Length);
                target = Locations[LocationIndex].transform;
                ScoreManager.score += 200;
                AmmoManager.ammo += 20;
            }
        }

        if (other.gameObject.tag == "Bowman")
        {
            if (LocationIndex == 5)
            {
                LocationIndex = Random.Range(0, Locations.Length);
                target = Locations[LocationIndex].transform;
                ScoreManager.score += 200;
                AmmoManager.ammo += 20;
            }
        }

        if (other.gameObject.tag == "Satterfield")
        {
            if (LocationIndex == 6)
            {
                LocationIndex = Random.Range(0, Locations.Length);
                target = Locations[LocationIndex].transform;
                ScoreManager.score += 200;
                AmmoManager.ammo += 20;
            }
        }

        if (other.gameObject.tag == "ISB")
        {
            if (LocationIndex == 7)
            {
                LocationIndex = Random.Range(0, Locations.Length);
                target = Locations[LocationIndex].transform;
                ScoreManager.score += 200;
                AmmoManager.ammo += 20;
            }
        }

        if (other.gameObject.tag == "SRB")
        {
            if (LocationIndex == 8)
            {
                LocationIndex = Random.Range(0, Locations.Length);
                target = Locations[LocationIndex].transform;
                ScoreManager.score += 200;
                AmmoManager.ammo += 20;
            }
        }

        if (other.gameObject.tag == "Smith")
        {
            if (LocationIndex == 9)
            {
                LocationIndex = Random.Range(0, Locations.Length);
                target = Locations[LocationIndex].transform;
                ScoreManager.score += 200;
                AmmoManager.ammo += 20;
            }
        }

        if (other.gameObject.tag == "Cunningham1")
        {
            if (LocationIndex == 10)
            {
                LocationIndex = Random.Range(0, Locations.Length);
                target = Locations[LocationIndex].transform;
                ScoreManager.score += 200;
                AmmoManager.ammo += 20;
            }
        }

        if (other.gameObject.tag == "Cunningham2")
        {
            if (LocationIndex == 11)
            {
                LocationIndex = Random.Range(0, Locations.Length);
                target = Locations[LocationIndex].transform;
                ScoreManager.score += 200;
                AmmoManager.ammo += 20;
            }
        }

        if (other.gameObject.tag == "Library")
        {
            if (LocationIndex == 12)
            {
                LocationIndex = Random.Range(0, Locations.Length);
                target = Locations[LocationIndex].transform;
                ScoreManager.score += 200;
                AmmoManager.ammo += 20;
            }
        }

        if (other.gameObject.tag == "MSB")
        {
            if (LocationIndex == 13)
            {
                LocationIndex = Random.Range(0, Locations.Length);
                target = Locations[LocationIndex].transform;
                ScoreManager.score += 200;
                AmmoManager.ammo += 20;
            }
        }

        if (other.gameObject.tag == "Terrace")
        {
            if (LocationIndex == 14)
            {
                LocationIndex = Random.Range(0, Locations.Length);
                target = Locations[LocationIndex].transform;
                ScoreManager.score += 200;
                AmmoManager.ammo += 20;
            }
        }

        if (other.gameObject.tag == "White")
        {
            if (LocationIndex == 15)
            {
                LocationIndex = Random.Range(0, Locations.Length);
                target = Locations[LocationIndex].transform;
                ScoreManager.score += 200;
                AmmoManager.ammo += 20;
            }
        }

        if (other.gameObject.tag == "Moulton")
        {
            if (LocationIndex == 16)
            {
                LocationIndex = Random.Range(0, Locations.Length);
                target = Locations[LocationIndex].transform;
                ScoreManager.score += 200;
                AmmoManager.ammo += 20;
            }
        }

        if (other.gameObject.tag == "Nixson")
        {
            if (LocationIndex == 17)
            {
                LocationIndex = Random.Range(0, Locations.Length);
                target = Locations[LocationIndex].transform;
                ScoreManager.score += 200;
                AmmoManager.ammo += 20;
            }
        }

        if (other.gameObject.tag == "Verder")
        {
            if (LocationIndex == 18)
            {
                LocationIndex = Random.Range(0, Locations.Length);
                target = Locations[LocationIndex].transform;
                ScoreManager.score += 200;
                AmmoManager.ammo += 20;
            }
        }

        if (other.gameObject.tag == "Taylor")
        {
            if (LocationIndex == 19)
            {
                LocationIndex = Random.Range(0, Locations.Length);
                target = Locations[LocationIndex].transform;
                ScoreManager.score += 200;
                AmmoManager.ammo += 20;
            }
        }

        if (other.gameObject.tag == "Engleman")
        {
            if (LocationIndex == 20)
            {
                LocationIndex = Random.Range(0, Locations.Length);
                target = Locations[LocationIndex].transform;
                ScoreManager.score += 200;
                AmmoManager.ammo += 20;
            }
        }

        if (other.gameObject.tag == "Oscar")
        {
            if (LocationIndex == 21)
            {
                LocationIndex = Random.Range(0, Locations.Length);
                target = Locations[LocationIndex].transform;
                ScoreManager.score += 200;
                AmmoManager.ammo += 20;
            }
        }

        if (other.gameObject.tag == "Lowry")
        {
            if (LocationIndex == 22)
            {
                LocationIndex = Random.Range(0, Locations.Length);
                target = Locations[LocationIndex].transform;
                ScoreManager.score += 200;
                AmmoManager.ammo += 20;
            }
        }

        if (other.gameObject.tag == "Olsen")
        {
            if (LocationIndex == 23)
            {
                LocationIndex = Random.Range(0, Locations.Length);
                target = Locations[LocationIndex].transform;
                ScoreManager.score += 200;
                AmmoManager.ammo += 20;
            }
        }

        if (other.gameObject.tag == "Dunbar")
        {
            if (LocationIndex == 24)
            {
                LocationIndex = Random.Range(0, Locations.Length);
                target = Locations[LocationIndex].transform;
                ScoreManager.score += 200;
                AmmoManager.ammo += 20;
            }
        }

        if (other.gameObject.tag == "Liquid")
        {
            if (LocationIndex == 25)
            {
                LocationIndex = Random.Range(0, Locations.Length);
                target = Locations[LocationIndex].transform;
                ScoreManager.score += 200;
                AmmoManager.ammo += 20;
            }
        }

        if (other.gameObject.tag == "Aero")
        {
            if (LocationIndex == 26)
            {
                LocationIndex = Random.Range(0, Locations.Length);
                target = Locations[LocationIndex].transform;
                ScoreManager.score += 200;
                AmmoManager.ammo += 20;
            }
        }

        if (other.gameObject.tag == "Henderson")
        {
            if (LocationIndex == 27)
            {
                LocationIndex = Random.Range(0, Locations.Length);
                target = Locations[LocationIndex].transform;
                ScoreManager.score += 200;
                AmmoManager.ammo += 20;
            }
        }

        if (other.gameObject.tag == "DIH")
        {
            if (LocationIndex == 28)
            {
                LocationIndex = Random.Range(0, Locations.Length);
                target = Locations[LocationIndex].transform;
                ScoreManager.score += 200;
                AmmoManager.ammo += 20;
            }
        }

        if (other.gameObject.tag == "BAD")
        {
            if (LocationIndex == 29)
            {
                LocationIndex = Random.Range(0, Locations.Length);
                target = Locations[LocationIndex].transform;
                ScoreManager.score += 200;
                AmmoManager.ammo += 20;
            }
        }

        if (other.gameObject.tag == "DoS")
        {
            if (LocationIndex == 30)
            {
                LocationIndex = Random.Range(0, Locations.Length);
                target = Locations[LocationIndex].transform;
                ScoreManager.score += 200;
                AmmoManager.ammo += 20;
            }
        }

        if (other.gameObject.tag == "CVA")
        {
            if (LocationIndex == 31)
            {
                LocationIndex = Random.Range(0, Locations.Length);
                target = Locations[LocationIndex].transform;
                ScoreManager.score += 200;
                AmmoManager.ammo += 20;

            }
        }

    }
}