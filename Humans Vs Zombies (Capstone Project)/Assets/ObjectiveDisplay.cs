using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.UI;

public class ObjectiveDisplay : MonoBehaviour
{

    Text text;
    // Start is called before the first frame update
    void Start()
    {
        text = GetComponent<Text>();
    }

    // Update is called once per frame
    void Update()
    {
        if (MissionWaypoint.LocationIndex == 0)
        {
            text.text = "Objective: Prentice Hall";
        }

        if (MissionWaypoint.LocationIndex == 1)
        {
            text.text = "Objective: Student Center";
        }

        if (MissionWaypoint.LocationIndex == 2)
        {
            text.text = "Objective: Gym Annex";
        }

        if (MissionWaypoint.LocationIndex == 3)
        {
            text.text = "Objective: MACC Building";
        }

        if (MissionWaypoint.LocationIndex == 4)
        {
            text.text = "Objective: Honors College";
        }

        if (MissionWaypoint.LocationIndex == 5)
        {
            text.text = "Objective: Bowman Hall";
        }

        if (MissionWaypoint.LocationIndex == 6)
        {
            text.text = "Objective: Satterfield Hall";
        }

        if (MissionWaypoint.LocationIndex == 7)
        {
            text.text = "Objective: Integrated Science";
        }

        if (MissionWaypoint.LocationIndex == 8)
        {
            text.text = "Objective: Science Research";
        }

        if (MissionWaypoint.LocationIndex == 9)
        {
            text.text = "Objective: Smith Hall" ;
        }

        if (MissionWaypoint.LocationIndex == 10)
        {
            text.text = "Objective: Cunningham Hall 1";
        }

        if (MissionWaypoint.LocationIndex == 11)
        {
            text.text = "Objective: Cunningham Hall 1";
        }

        if (MissionWaypoint.LocationIndex == 12)
        {
            text.text = "Objective:  Library";
        }

        if (MissionWaypoint.LocationIndex == 13)
        {
            text.text = "Objective: MSB";
        }
        if (MissionWaypoint.LocationIndex == 14)
        {
            text.text = "Objective: Terrace Hall";
        }

        if (MissionWaypoint.LocationIndex == 15)
        {
            text.text = "Objective: White Hall";
        }

        if (MissionWaypoint.LocationIndex == 16)
        {
            text.text = "Objective: Moulton Hall";
        }

        if (MissionWaypoint.LocationIndex == 17)
        {
            text.text = "Objective: Nixson Hall";
        }

        if (MissionWaypoint.LocationIndex == 18)
        {
            text.text = "Objective: Verder Hall";
        }

        if (MissionWaypoint.LocationIndex == 19)
        {
            text.text = "Objective: Taylor Hall";
        }

        if (MissionWaypoint.LocationIndex == 20)
        {
            text.text = "Objective: Engleman Hall";
        }

        if (MissionWaypoint.LocationIndex == 21)
        {
            text.text = "Objective: Oscar Richie Hall";
        }

        if (MissionWaypoint.LocationIndex == 22)
        {
            text.text = "Objective: Lowry Hall";
        }

        if (MissionWaypoint.LocationIndex == 23)
        {
            text.text = "Objective: Olsen/Lake Hall";
        }

        if (MissionWaypoint.LocationIndex == 24)
        {
            text.text = "Objective: Dunbar Hall";
        }

        if (MissionWaypoint.LocationIndex == 25)
        {
            text.text = "Objective: Liquid Crystals MSB";
        }

        if (MissionWaypoint.LocationIndex == 26)
        {
            text.text = "Objective: Aronautics & Engineering";
        }

        if (MissionWaypoint.LocationIndex == 27)
        {
            text.text = "Objective: Henderson Hall";
        }

        if (MissionWaypoint.LocationIndex == 28)
        {
            text.text = "Objective: Design Innovation Hub";
        }

        if (MissionWaypoint.LocationIndex == 29)
        {
            text.text = "Objective: Business Administration";
        }

        if (MissionWaypoint.LocationIndex == 30)
        {
            text.text = "Objective: Dept. Of Sociology";
        }

        if (MissionWaypoint.LocationIndex == 31)
        {
            text.text = "Objective: Prentice";
        }

    }
}
