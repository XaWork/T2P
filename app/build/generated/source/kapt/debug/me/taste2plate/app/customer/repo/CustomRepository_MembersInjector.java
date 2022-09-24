// Generated by Dagger (https://dagger.dev).
package me.taste2plate.app.customer.repo;

import dagger.MembersInjector;
import dagger.internal.DaggerGenerated;
import dagger.internal.InjectedFieldSignature;
import javax.inject.Provider;
import me.taste2plate.app.Woocommerce;

@DaggerGenerated
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class CustomRepository_MembersInjector implements MembersInjector<CustomRepository> {
  private final Provider<Woocommerce> woocommerceProvider;

  public CustomRepository_MembersInjector(Provider<Woocommerce> woocommerceProvider) {
    this.woocommerceProvider = woocommerceProvider;
  }

  public static MembersInjector<CustomRepository> create(
      Provider<Woocommerce> woocommerceProvider) {
    return new CustomRepository_MembersInjector(woocommerceProvider);
  }

  @Override
  public void injectMembers(CustomRepository instance) {
    injectWoocommerce(instance, woocommerceProvider.get());
  }

  @InjectedFieldSignature("me.taste2plate.app.customer.repo.CustomRepository.woocommerce")
  public static void injectWoocommerce(CustomRepository instance, Woocommerce woocommerce) {
    instance.woocommerce = woocommerce;
  }
}