using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace FehCalculator_WFA
{
    class GrailUnit
    {
        public String name_;
        public int grails_;
        public int feathers_;

        public GrailUnit(String name, int grails, int feathers)
        {
            name_ = name;
            grails_ = grails;
            feathers_ = feathers;
        } 
    }
}
