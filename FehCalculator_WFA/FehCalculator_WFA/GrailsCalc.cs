using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace FehCalculator_WFA
{
    public partial class GrailsCalc : Form
    {


        //Grail list
        //List<GrailUnit> grailList = new List<GrailUnit>();
        //BindingSource bs = new BindingSource();
        public GrailsCalc()
        {
            InitializeComponent();
        }
        
        private void button_GrailCalc_Click(object sender, EventArgs e)
        {
            //Error Check: Text box can't be null
            /*if (string.IsNullOrEmpty(numericUpDown_grailsBuying.Text) || string.IsNullOrEmpty(textBox_grail.Text))
            {
                label_grailResult.Text = "No input. Please enter a number";

            }
            //Error Check: Number must be entered
            else if (!textBox_copies.Text.All(char.IsDigit) || !textBox_grail.Text.All(char.IsDigit))
            {
                label_grailResult.Text = "Invalid input. Please enter a number";
            }
            else
            {*/
            //convert input into variables
            string unitName = comboBox_Grail.GetItemText(comboBox_Grail.SelectedItem);
            int buying = Convert.ToInt32(Math.Round(numericUpDown_grailsBuying.Value, 0));
            int bought = Convert.ToInt32(Math.Round(numericUpDown_grailsBought.Value, 0));

            //Error Check: You can't buy more then 20 copies of a single unit
            if (buying + bought > 20)
            {
                label_grailResult.Text = "Invalid input. You can't buy this many units with grails";
            }
            else
                {
                    //feather cost
                    int feathers = buying * 20000;

                    //grail cost
                    int grails = 0;
                    for (int i = bought; i < (buying - bought); i++)
                    {
                        if (i < 9)
                            grails += 100 + (50 * i);
                        else
                            grails += 500;
                    }
                    //label_grailResult.Text = "This will cost " + grails + " grails and " + feathers + " feathers";
                    //grailList.Add(grails);
                    //listGrailList.DataSource = bs;
                    //bs.ResetBindings(false);
                    ListViewItem unit = new ListViewItem(unitName);
                    unit.SubItems.Add(grails.ToString());
                    unit.SubItems.Add(feathers.ToString());
                    listView_grailList.Items.Add(unit);
                    int sumGrails = 0;
                    int sumFeathers = 0;
                    foreach(ListViewItem item in listView_grailList.Items)
                    {
                        sumGrails += int.Parse(item.SubItems[1].Text);
                        sumFeathers += int.Parse(item.SubItems[2].Text);
                    }
                    label_grailResult.Text = "Total Grails: " + sumGrails + "     Feathers: " + sumFeathers;
                }
        }

        private void GrailsCalc_Load(object sender, EventArgs e)
        {
            List<string> grailShopInventory = System.IO.File.ReadLines
                (@"C:\Users\Charlie\source\repos\FehCalculator_WFA\FehCalculator_WFA\GrailShopInventory.txt").ToList();
            comboBox_Grail.DataSource = grailShopInventory;

        }
    }
}
