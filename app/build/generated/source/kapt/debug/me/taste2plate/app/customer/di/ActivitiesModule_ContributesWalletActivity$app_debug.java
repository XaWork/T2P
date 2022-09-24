package me.taste2plate.app.customer.di;

import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;
import me.taste2plate.app.customer.ui.wallet.WalletActivity;

@Module(
  subcomponents =
      ActivitiesModule_ContributesWalletActivity$app_debug.WalletActivitySubcomponent.class
)
public abstract class ActivitiesModule_ContributesWalletActivity$app_debug {
  private ActivitiesModule_ContributesWalletActivity$app_debug() {}

  @Binds
  @IntoMap
  @ClassKey(WalletActivity.class)
  abstract AndroidInjector.Factory<?> bindAndroidInjectorFactory(
      WalletActivitySubcomponent.Factory builder);

  @Subcomponent
  public interface WalletActivitySubcomponent extends AndroidInjector<WalletActivity> {
    @Subcomponent.Factory
    interface Factory extends AndroidInjector.Factory<WalletActivity> {}
  }
}
