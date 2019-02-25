README
Plugin for taking multishot photos, developed by vortech-it.com

What is this repository for?
cordova based projects

How do I get set up?
cordova plugin add https://github.com/AngelBarrera/multishotbyniido

How to use it?
1.- wait for the platform to be ready

2.- Multishot is appendeddirectly to window global object, use it like so: window.Multishot.capture(data, success, error); or: Multishot.capture(data, success, error);

PARAMS TYPE: data: [camera_type, number_of_photos, seconds_between_photos] data: [camera_type:{"front"|"back"}, number_of_photos:{number}, seconds_between_photo:{number}] *where seconds_between_photos >= number_of_photos

EXAMPLE: capture(["front", 4, 6], function success(resp){...}, function error(error){...});

where: success([photos_path:{string}]) = array with the photo's path error({string})
