#import <Foundation/Foundation.h>
#import <Capacitor/Capacitor.h>


// Define the plugin using the CAP_PLUGIN Macro, and
// each method the plugin supports using the CAP_PLUGIN_METHOD macro.
CAP_PLUGIN(CapacitorMusicControls, "CapacitorMusicControls",
    CAP_PLUGIN_METHOD(create, CAPPluginReturnPromise);
    CAP_PLUGIN_METHOD(updateIsPlaying, CAPPluginReturnPromise);
    CAP_PLUGIN_METHOD(updateElapsed, CAPPluginReturnPromise);
   // CAP_PLUGIN_METHOD(listen, CAPPluginReturnPromise);
    CAP_PLUGIN_METHOD(destroy, CAPPluginReturnPromise);
)
