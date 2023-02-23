import { WebPlugin } from '@capacitor/core';

import { CapacitorMusicControlsInfo, CapacitorMusicControlsPlugin } from ".";

export class CapacitorMusicControlsWeb extends WebPlugin implements CapacitorMusicControlsPlugin {
    constructor() {
        super({
            name: 'CapacitorMusicControls',
            platforms: ['web'],
        });
    }

    create(options: CapacitorMusicControlsInfo): Promise<any> {
        console.log('create', options);
        return Promise.resolve(undefined);
    }

    destroy(): Promise<any> {
        return Promise.resolve(undefined);
    }

    updateDismissable(dismissable: boolean): void {
        console.log('updateDismissable', dismissable);
    }

    updateElapsed(args: { elapsed: number; isPlaying: boolean }): void {
        console.log('updateElapsed', args);
    }

    updateIsPlaying(args: { elapsed: number; isPlaying: boolean }): void {
        console.log('updateIsPlaying', args);
    }

}