import { registerPlugin } from '@capacitor/core';

import type { CapacitorMusicControlsPlugin } from './definitions';

const CapacitorMusicControls = registerPlugin<CapacitorMusicControlsPlugin>('CapacitorMusicControls', {
    web: () => import('./web').then(m => new m.CapacitorMusicControlsWeb()),
});

export * from './definitions';
export { CapacitorMusicControls };