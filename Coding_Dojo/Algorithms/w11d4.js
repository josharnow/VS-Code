// clock angles

// given a number of minutes past midnight, determine
// the angle between the hour and minute hands at that point in time
// keep in mind that on an analog clock, the hour hand is
// not perfectly aligned with the number hour
// e.g. at 4:45, the hour hand is 3/4 the way between 4 and 5.

const clockAngles = (minutes) => {

  let minHand = ((minutes % 60) / 60) * 360;
  let hourHand = ((minutes % 720) * 0.5);

  let angle = minHand - hourHand;

  if (angle < 0) {
    angle += 360;
  }

  if (angle > 180) {
    angle = 360 - angle; 
  }

  return angle;
}

console.log(clockAngles(980));