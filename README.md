# Godot-TimeElapsed
This is an Android module for [Godot Engine](https://github.com/okamstudio/godot).

This module can track time bound events on Android. I.e. Time since last start. It's not affected by local timezone or date. It doesn't work in background as a sevice.

## Installation
- Copy `elapsed` folder inside the `modules` directory of the Godot source.

- You must [recompile](https://godot.readthedocs.io/en/stable/development/compiling/compiling_for_android.html) Godot for Android.

- Finally, you need to include the module in your `engine.cfg` (if you have more than one module separate them by comma):
```
[android]
modules="org/godotengine/godot/TimeElapsed"
``` 

## How to use
It's a very dull module:

```python
var old_time_secs = null
var time_elapsed = null

func _ready():
    if Globals.has_singleton("TimeElapsed"):
        time_elapsed = Globals.get_singleton("TimeElapsed")
    pass

func get_difference():
    if time_elapsed != null and old_time_secs != null:
        return time_elapsed.getDifferenceSeconds(old_time_secs)
    return -1

func get_current_time_secs():
    # It's useful to save that data before app quits and
    # then compare it to current one when the app is started again
    # i.e. you want to reset some cooldown, but want it to be timezone independent
    old_time_secs = getNanoTimeInSeconds()
    pass
```

## API Reference
The following methods are available:

```python
# Get current nanotime in seconds
getNanoTimeInSeconds()

# Get current nanotime in minutes
getNanoTimeInMinutes()

# Get current nanotime in hours
getNanoTimeInHours()

# Get difference between previous nanotime in seconds and the current one
# @param String prevHours Previous nanotime value in seconds
getDifferenceSeconds(prevSecs)

# Get difference between previous nanotime in minutes and the current one
# @param String prevHours Previous nanotime value in minutes
getDifferenceMinutes(prevMins)

# Get difference between previous nanotime in hours and the current one
# @param String prevHours Previous nanotime value in hours
getDifferenceHours(prevHours)
```
