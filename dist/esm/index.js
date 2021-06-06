import { registerPlugin } from '@capacitor/core';
const CapacitorMusicControls = registerPlugin('CapacitorMusicControls', {
    web: () => import('./web').then(m => new m.CapacitorMusicControlsWeb()),
});
export * from './definitions';
export { CapacitorMusicControls };
//# sourceMappingURL=index.js.map